package com.revature.BackEnd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


import com.revature.domain.Employee;
import com.revature.domain.Reimburse;
import com.revature.domain.UsernameAlreadyUsedException;
import com.revature.util.ConnectionUtil;

import oracle.sql.TIMESTAMP;

public class EmployeeDaoImpl implements EmployeeDao {

	private String filename = "connection.properties";

	@Override
	public int getUsername(String username) {
		// look for the valid username and return employeeID

		int validUser = 0;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME_EMAIL = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				validUser = rs.getInt("EMPLOYEEID");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return validUser;

	}

	@Override
	public String getPassword(String username) {
		// Looking for the valid password
		String validPassword = null;
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME_EMAIL = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				validPassword = rs.getString("USER_PASSWORD");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return validPassword;

	}

	@Override
	public String getUserRole(String username, String password) {
		String userRole = null;

		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USER_ROLE FROM EMPLOYEE WHERE USERNAME_EMAIL =? AND USER_PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				userRole = rs.getString("USER_ROLE");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRole;
	}

	@Override
	public String updatepassword(String username, String password) {
		String newpassword = null;

		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			String sql = "UPDATE USER_PASSWORD SET USER_PASSWORD = ? WHERE USERNAME_EMAIL = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return newpassword;
	}

	@Override
	public String login(String username, String password) {

		String userRole = null;

		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USER_ROLE FROM EMPLOYEE WHERE USERNAME_EMAIL =? AND USER_PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				userRole = rs.getString("USER_ROLE");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRole;

	}

	@Override
	public Employee viewInfo(String username) {
		// TODO Auto-generated method stub
		Employee em = new Employee();

		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE WHERE USERNAME_EMAIL =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				em.setFirstName(rs.getString("FIRSTNAME"));
				em.setLastName(rs.getString("LASTNAME"));
				em.setUsername(rs.getString("USERNAME_EMAIL"));
				em.setRole(rs.getString("USER_ROLE"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return em;
	}

	@Override
	public void updateInfo(Employee e, String username) {

		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE EMPLOYEE SET FIRSTNAME =?, LASTNAME =? WHERE USERNAME_EMAIL =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, e.getFirstName());
			pstmt.setString(2, e.getLastName());
			pstmt.setString(3, username);
			
			
			pstmt.executeQuery();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	@Override
	public String resetpassword(String username, String password) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE EMPLOYEE SET USER_PASSWORD = ? WHERE USERNAME_EMAIL=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			

			pstmt.executeQuery();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return password;

	}

	@Override
	public void submitReimbursement(String username, Reimburse r) {
		// TODO Auto-generated method stub
		int employeeID = 0;

		PreparedStatement pstmt = null;
		// PreparedStatement pstmt1 = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT EMPLOYEEID FROM EMPLOYEE WHERE USERNAME_EMAIL=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				employeeID = rs.getInt("EMPLOYEEID");
			}

			sql = "INSERT INTO REIMBURSEMENT (AMOUNT,DESCRIPTION,STATUS,EMPLOYEEID) VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, r.getAmount());
			pstmt.setString(2, r.getDescription());
			pstmt.setString(3, r.getStatus());
			pstmt.setInt(4, employeeID);
			pstmt.executeQuery();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	@Override
	public ArrayList<Reimburse> viewSubmittedReimburseInfo(String username) {

		Employee em = new Employee();
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEEID = (SELECT EMPLOYEEID FROM EMPLOYEE WHERE  USERNAME_EMAIL = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimburse r1 = new Reimburse();
				java.sql.Timestamp ts = rs.getTimestamp("DATE_SUBMITTED");
				r1.setAmount(rs.getDouble("AMOUNT"));
				r1.setDescription(rs.getString("DESCRIPTION"));
				r1.setStatus(rs.getString("STATUS"));
				r1.setSubmitted(ts);
				r.add(r1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Reimburse> viewPendingReimburseInfo(String username) {

		
		Employee em = new Employee();
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		ArrayList<Reimburse> rOpen = new ArrayList<Reimburse>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEEID = (SELECT EMPLOYEEID FROM EMPLOYEE WHERE  USERNAME_EMAIL = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimburse r1 = new Reimburse();	
				r1.setAmount(rs.getDouble("AMOUNT"));
				r1.setDescription(rs.getString("DESCRIPTION"));
				r1.setStatus(rs.getString("STATUS"));				
				r.add(r1);
			}
			
			for(Reimburse s: r) {
				if(s.getStatus().equals("open")) {
					s.getAmount();
					s.getDescription();
					rOpen.add(s);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rOpen;
	}
	
	@Override
	public ArrayList<Reimburse> viewClosedReimburseInfo(String username) {

		
		Employee em = new Employee();
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		ArrayList<Reimburse> rOpen = new ArrayList<Reimburse>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEEID = (SELECT EMPLOYEEID FROM EMPLOYEE WHERE  USERNAME_EMAIL = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimburse r1 = new Reimburse();	
				java.sql.Timestamp ts = rs.getTimestamp("DATE_SUBMITTED");
				r1.setAmount(rs.getDouble("AMOUNT"));
				r1.setDescription(rs.getString("DESCRIPTION"));
				r1.setStatus(rs.getString("STATUS"));
				r1.setSubmitted(ts);
				r.add(r1);
			}
			
			for(Reimburse s: r) {
				if(s.getStatus().equals("closed")) {
					s.getAmount();
					s.getDescription();
					rOpen.add(s);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rOpen;
	}

	@Override
	public ArrayList<Employee> viewEmployees() throws SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<Employee> users = new ArrayList<>();
		ArrayList<Employee> others = new ArrayList<Employee>();
		
		
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM EMPLOYEE LEFT JOIN EMPLOYEEROLE ON EMPLOYEE.EMPLOYEEID = EMPLOYEEROLE.EMPLOYEEID";
			pstmt = con.prepareStatement(sql);		
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee em = new Employee();
				em.setEmployeeId(rs.getInt("EMPLOYEEID"));
				em.setFirstName(rs.getString("FIRSTNAME"));
				em.setLastName(rs.getString("LASTNAME"));
				em.setUsername(rs.getString("USERNAME_EMAIL"));
				em.setRole(rs.getString("USER_ROLE"));				
				users.add(em);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
		
	}

	@Override
	public ArrayList<Reimburse> viewClosedReimburseAllInfo() {
		Employee em = new Employee();
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		ArrayList<Reimburse> closed = new ArrayList<Reimburse>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENT";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Employee e = new Employee();

			while (rs.next()) {
				Reimburse r1 = new Reimburse();
				java.sql.Timestamp ts = rs.getTimestamp("DATE_SUBMITTED");
				
				r1.setReimburseid(rs.getInt("REIMBURSEMENTID"));
				r1.setAmount(rs.getDouble("AMOUNT"));
				r1.setDescription(rs.getString("DESCRIPTION"));
				r1.setStatus(rs.getString("STATUS"));
				r1.setEmpID(rs.getInt("EMPLOYEEID"));
				r1.setSubmitted(ts);
				r.add(r1);
			}

			for (Reimburse s : r) {
				if (s.getStatus().equals("closed")) {
					s.getAmount();
					s.getDescription();
					closed.add(s);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return closed;
	}

	@Override
	public ArrayList<Reimburse> viewPendingReimburseAllInfo() {
		
	
		// TODO Auto-generated method stub
		Employee em = new Employee();
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		ArrayList<Reimburse> rOpen = new ArrayList<Reimburse>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
					
			String sql = "SELECT * FROM REIMBURSEMENT";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimburse r1 = new Reimburse();
				java.sql.Timestamp ts = rs.getTimestamp("DATE_SUBMITTED");
				r1.setReimburseid(rs.getInt("REIMBURSEMENTID"));
				r1.setAmount(rs.getDouble("AMOUNT"));
				r1.setDescription(rs.getString("DESCRIPTION"));
				r1.setStatus(rs.getString("STATUS"));
				r1.setEmpID(rs.getInt("EMPLOYEEID"));
				r1.setSubmitted(ts);
				r.add(r1);
			}

			for (Reimburse s : r) {
				if (s.getStatus().equals("open")) {
					s.getAmount();
					s.getDescription();
					rOpen.add(s);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rOpen;

}


	@Override
	public void approveReimburse(Reimburse r,String status, int reimbid) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {			
			String sql = "UPDATE REIMBURSEMENT SET STATUS= ?  WHERE REIMBURSEMENTID=? ";			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,status );
			pstmt.setInt(2, reimbid);			
			pstmt.executeQuery();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}

	@Override
	public void updateInfoManager( String username, String password ) {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE EMPLOYEE SET USER_PASSWORD =? WHERE USERNAME_EMAIL =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, username);
			
			pstmt.executeQuery();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	@Override
	public ArrayList<Reimburse> viewPendingReimburseperUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerUser(String firstname, String lastname, String role, String username,String password) {
		
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {			
			String sql = "INSERT INTO EMPLOYEE(FIRSTNAME,LASTNAME,USER_ROLE,USERNAME_EMAIL,USER_PASSWORD) VALUES (?,?,?,?,?)";			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,firstname);
			pstmt.setString(2, lastname);		
			pstmt.setString(3, role);	
			pstmt.setString(4, username);	
			pstmt.setString(5, password);	
			pstmt.executeQuery();

		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}

	/*@Override
	public ArrayList<Reimburse> viewPendingReimburseByUsername(String username) {

		Employee em = new Employee();
		ArrayList<Reimburse> r = new ArrayList<Reimburse>();
		ArrayList<Reimburse> rOpen = new ArrayList<Reimburse>();
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEEID = (SELECT EMPLOYEEID FROM EMPLOYEE WHERE  USERNAME_EMAIL = ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimburse r1 = new Reimburse();	
				java.sql.Timestamp ts = rs.getTimestamp("DATE_SUBMITTED");
				r1.setAmount(rs.getDouble("AMOUNT"));
				r1.setDescription(rs.getString("DESCRIPTION"));
				r1.setStatus(rs.getString("STATUS"));
				r1.setSubmitted(ts);
				r.add(r1);
			}
			
			for(Reimburse s: r) {
				if(s.getStatus().equals("open")) {
					s.getAmount();
					s.getDescription();
					s.getSubmitted();
					rOpen.add(s);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rOpen;
	}*/
}
