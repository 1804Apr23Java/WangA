package TestCase;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.revature.BackEnd.EmployeeDao;
import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Reimburse;
import com.revature.util.ConnectionUtil;

public class EmployeeTestCase  {

	private String filename = "connection.properties";

	EmployeeDao ed = new EmployeeDaoImpl();
	Reimburse r = new Reimburse();

	@Test
	public void userRoleTestCase() {
		ed.getUserRole("shivam.aashir@gmail.com","test123");
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USER_ROLE FROM EMPLOYEE WHERE USERNAME_EMAIL =?";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertEquals("Manager", rs.getString(" USER_ROLE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void updatepasswordtestcase() {
		ed.updatepassword("shivam.aashir@gmail.com","test");
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USER_PASSWORD FROM EMPLOYEE WHERE USERNAME_EMAIL =?";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertEquals("test", rs.getString("USER_PASSWORD"));
				}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void validlogin() {
		ed.login("shivam.aashir@gmail.com","test");
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT USER_ROLE FROM EMPLOYEE WHERE USERNAME_EMAIL =? AND USER_PASSWORD";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertEquals("manager", rs.getString("USER_ROLE"));			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void viewinfotest() {
		Employee em2 = ed.viewInfo("j.malik@gmail.com");
		Employee em = new Employee();
		
		String username = "j.malik@gmail.com";
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
				
				Assert.assertEquals(em2.getFirstName(), "jordan");	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void updateInfoTest() {
		Employee em2 = ed.viewInfo("charlie.lwi@gmail.com");
		Employee e = new Employee();
		ed.updateInfo(e, "charlie.lwi@gmail.com");
		
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "UPDATE EMPLOYEE SET FIRSTNAME =?, LASTNAME =? WHERE USERNAME_EMAIL =? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "charles");
			pstmt.setString(2, "lwi");
			pstmt.setString(3, "charlie.lwi@gmail.com");		
			
			pstmt.executeQuery();

				Assert.assertEquals(em2.getFirstName(),"charles");	
			

		} catch (SQLException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		} catch (IOException es) {
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
	}

	@Test
	public void submitReimbursementtest() {
		ArrayList<Reimburse> r1 = new ArrayList<Reimburse>();
		ArrayList<Reimburse> r2 = new ArrayList<Reimburse>();
		String username = "j.malik@gmail.com";
		r.setAmount(210);
		r.setDescription("food");
		r.setEmpID(42);
		r1.add(r);
		ed.submitReimbursement(username, r);
		r2 = ed.viewSubmittedReimburseInfo(username);
		 System.out.println(r2.size());
		 double amount =r2.get(1).getAmount();
		 Assert.assertTrue(r2.size()>21);
		

		

	}
	@Test
	public void viewPendingReimburseinfoTest() {
		ArrayList<Reimburse> r1 = new ArrayList<Reimburse>();
		String username = "j.malik@gmail.com";
		ed.viewPendingReimburseInfo(username);
		for (Reimburse r : r1) {
			System.out.println(r.getAmount());
		}

	}
	@Test
	public void viewEmployeeListtest() {		
		
		ArrayList<Employee> r2 = new ArrayList<Employee>();
		ArrayList<Employee> r1 = new ArrayList<Employee>(r2);
		Employee e = new Employee();
		e.setEmployeeId(41);
		e.setFirstName("charles");
		e.setLastName("lwi");
		e.setUsername("charlie.lwi@gmail.com");
		e.setRole("employee");
		r2.add(e);
		System.out.println(e);
		
		try {
			r1=ed.viewEmployees();
			System.out.println(r1.get(2));
			Assert.assertEquals(r1.get(2),r2);
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}	
	
	@Test
	public void addEmployeeTest() {
		EmployeeDao ed = new EmployeeDaoImpl();		
		ed.registerUser("Logan","GoldHorn","employee","logan.gold@gmail.com","test");
		
		
	}

}
