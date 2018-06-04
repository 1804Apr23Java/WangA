package testcase;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.revature.dao.AdminDao;
import com.revature.dao.AdminDaoPLSQL;
import com.revature.dao.BankClientDaoPLSQL;
import com.revature.domain.Account;
import com.revature.domain.BankClient;
import com.revature.domain.UsernameAlreadyUsedException;
import com.revature.util.ConnectionUtil;

public class testjunit {

	private String filename = "connection.properties";
	
	AdminDaoPLSQL admintest = new AdminDaoPLSQL();
	BankClientDaoPLSQL bctest =  new BankClientDaoPLSQL();
	List<Account> acc = new ArrayList<Account>();
	List<BankClient> bc = new ArrayList<BankClient>();

	/*@SuppressWarnings("unlikely-arg-type")

	@Test
	public void getBankClientbybankclientID() {
		admintest.getBankClient(1);
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANKCLIENT where bankclientid=1";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertEquals("Jordan123", rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void updatebankclientusernametest() {
		PreparedStatement pstmt = null;
		admintest.updateBankClientPassword(1, "Iamhere");
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT PASSWORD FROM BANKCLIENT where bankclientid=1";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertEquals("Iamhere", rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createBankClientforaddinuser() throws UsernameAlreadyUsedException {

		admintest.createBankClient("admintesting2", "Testing1235");

		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANKCLIENT where bankclientid=13";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertEquals("admintesting2", rs.getString("username"));
				Assert.assertEquals("Testing1235", rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void deleteBankClientforaddinuser() {

		admintest.deleteBankClient(13);

		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM BANKCLIENT where bankclientid=13";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertEquals(null, rs.getString("BankClientID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void createAccounttestcreatingIDdepositbalance() {
		PreparedStatement pstmt = null;
		bctest.createAccount(1,500);
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT ACCOUNTBALANCE FROM account where bankclientid=13";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Assert.assertSame(725.00, rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	@Test
	public void viewaccountusingtheclientid() {
		PreparedStatement pstmt = null;
		bctest.viewAccounts(1);
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT Accountid, accountbalance FROM ACCOUNT WHERE BANKCLIENTID=1";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			List <Integer> actualresault = new ArrayList<Integer>();
			List <Integer> expected = new ArrayList<Integer>();
			expected.add(5);
			expected.add(22);
			expected.add(28);
			expected.add(29);
			expected.add(30);		
			
			while (rs.next()) {		
				actualresault.add(rs.getInt("AccountID"));
				
				}
			Assert.assertEquals(expected, actualresault);;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
