package com.revature.java.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.java.domain.Employee;
import com.revature.java.domain.Request;
import com.revature.util.ConnectionTest;

public class EmpDaoImpl implements EmpDao {

	public boolean empLogin(int empID, String password) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? AND PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void submitRequest(int empID, Request r) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "INSERT INTO REQUESTS(EMPLOYEE_ID, COMMENTS, REQUEST_AMT, RECEIPT_IMG) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			pstmt.setString(2, r.getComment());
			pstmt.setInt(3, r.getAmount());
			pstmt.setString(4, r.getReceipt());
			pstmt.executeQuery();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public List<Request> viewPending(int empID) {
		List<Request> reqList = new ArrayList<Request>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUESTS LEFT JOIN RESOLUTIONS ON REQUESTS.REQUEST_ID = RESOLUTIONS.REQUEST_ID WHERE RESOLUTIONS.MANAGER_ID IS NULL AND EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int requestID = rs.getInt("REQUEST_ID");
				int employeeID = rs.getInt("EMPLOYEE_ID");
				String comments = rs.getString("COMMENTS");
				int amount = rs.getInt("REQUEST_AMT");
				String receipt = rs.getString("RECEIPT_IMG");
				Date dateCreated = rs.getDate("DATE_CREATED");
				reqList.add(new Request(requestID, employeeID, comments, amount, receipt, dateCreated, 0, null, null));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reqList;				
	}

	public List<Request> viewResolved(int empID) {
		List<Request> reqList = new ArrayList<Request>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUESTS LEFT JOIN RESOLUTIONS ON REQUESTS.REQUEST_ID = RESOLUTIONS.REQUEST_ID WHERE EMPLOYEE_ID = ? AND MANAGER_ID IS NOT NULL";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int requestID = rs.getInt("REQUEST_ID");
				int employeeID = rs.getInt("EMPLOYEE_ID");
				String comments = rs.getString("COMMENTS");
				int amount = rs.getInt("REQUEST_AMT");
				String receipt = rs.getString("RECEIPT_IMG");
				Date dateCreated = rs.getDate("DATE_CREATED");
				int managerID = rs.getInt("MANAGER_ID");
				String status = rs.getString("STATUS");
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				reqList.add(new Request(requestID, employeeID, comments, amount, receipt, dateCreated, managerID, status, dateResolved));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reqList;				
	}

	public void updateInfo(int empID) {
		// TODO Auto-generated method stub
		
	}

	public Employee viewEmpInfo(int empID) {
		Employee emp = null;
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("EMP_FNAME");
				String lastName = rs.getString("EMP_LNAME");
				String email = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				emp = new Employee(empID, firstName, lastName, password, email);
			}	
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emp;
	}
}
