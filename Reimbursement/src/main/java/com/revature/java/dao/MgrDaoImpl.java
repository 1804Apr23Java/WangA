package com.revature.java.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.java.domain.Employee;
import com.revature.java.domain.Manager;
import com.revature.java.domain.Request;
import com.revature.util.ConnectionTest;

public class MgrDaoImpl implements MgrDao {

	public boolean mgrLogin(int mgrID, String password) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM MANAGERS WHERE MANAGER_ID = ? AND PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mgrID);
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
	
	public List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM EMPLOYEES";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int empID = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("EMP_FNAME");
				String lastName = rs.getString("EMP_LNAME");
				String password = rs.getString("PASSWORD");
				String email = rs.getString("EMAIL");
				Employee e = new Employee(empID, firstName, lastName, password, email);
				empList.add(e);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empList;		
	}
	
	public void approveRequest(int requestID) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "INSERT INTO RESOLUTIONS(REQUEST_ID, MANAGER_ID, STATUS) VALUES(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, requestID);
			pstmt.setInt(2, Manager.getManagerID());
			pstmt.setString(3,"APPROVED");
			pstmt.executeQuery();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void denyRequest(int requestID) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "INSERT INTO RESOLUTIONS(REQUEST_ID, MANAGER_ID, STATUS) VALUES(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, requestID);
			pstmt.setInt(2, Manager.getManagerID());
			pstmt.setString(3,"DENIED");
			pstmt.executeQuery();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Request> viewPending() {
		List<Request> reqList = new ArrayList<Request>();
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUESTS LEFT JOIN RESOLUTIONS ON REQUESTS.REQUEST_ID = RESOLUTIONS.REQUEST_ID WHERE RESOLUTIONS.MANAGER_ID IS NULL";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
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

	public List<Request> viewResolved() {
		List<Request> reqList = new ArrayList<Request>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM RESOLUTIONS LEFT JOIN REQUESTS ON RESOLUTIONS.REQUEST_ID = REQUESTS.REQUEST_ID";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int requestID = rs.getInt("REQUEST_ID");
				int employeeID = rs.getInt("EMPLOYEE_ID");
				String comments = rs.getString("COMMENTS");
				int requestAmt = rs.getInt("REQUEST_AMT");
				String receipt = rs.getString("RECEIPT_IMG");
				Date dateCreated = rs.getDate("DATE_CREATED");
				int managerID = rs.getInt("MANAGER_ID");
				String status = rs.getString("STATUS");
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				reqList.add(new Request(requestID, employeeID, comments, requestAmt, receipt, dateCreated, managerID, status, dateResolved));
			}			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reqList;
	}

	public List<Request> viewByEmpId(int id) {
		List<Request> reqList = new ArrayList<Request>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM REQUESTS LEFT JOIN RESOLUTIONS USING (REQUEST_ID) WHERE EMPLOYEE_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int requestID = rs.getInt("REQUEST_ID");
				int employeeID = rs.getInt("EMPLOYEE_ID");
				String comments = rs.getString("COMMENTS");
				int requestAmt = rs.getInt("REQUEST_AMT");
				String receipt = rs.getString("RECEIPT_IMG");
				Date dateCreated = rs.getDate("DATE_CREATED");
				int managerID = rs.getInt("MANAGER_ID");
				String status = rs.getString("STATUS");
				Date dateResolved = rs.getDate("DATE_RESOLVED");
				Request r = new Request(requestID, employeeID, comments, requestAmt, receipt, dateCreated, managerID, status, dateResolved);
				reqList.add(r);
			}			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reqList;
	}

	public Manager mgrInfo(int mgrID) {
		Manager m = null;
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile()) {
			String sql = "SELECT * FROM MANAGERS WHERE MANAGER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mgrID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int managerID = rs.getInt("MANAGER_ID");
				String firstName = rs.getString("MGR_FNAME");
				String lastName = rs.getString("MGR_LNAME");
				String password = rs.getString("PASSWORD");
				m = new Manager(managerID, firstName, lastName, password);
			}	
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return m;
	}
}
