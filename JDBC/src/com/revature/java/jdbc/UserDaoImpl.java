package com.revature.java.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.revature.util.jdbc.ConnectionTest;

public class UserDaoImpl implements UserDao {
	private static String filename = "dbconnection.properties";
	private static String userID;
	private static String password;
	private static String bankAccountID;

	public static List<Account> getAccounts(User a) {
		List<Account> acctList = new ArrayList<>();
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID = " + a.getID();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String userID = rs.getString("USER_ID");
				String acctID = rs.getString("BANK_ACCOUNT_ID");
				double balance = rs.getDouble("BALANCE");
				acctList.add(new Account(userID, acctID, balance));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return acctList;
	}
	
	public static void createUserAccount() {	
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a password.");
			password = sc.nextLine();
			String sql = "INSERT INTO USERS VALUES(SQ_USER_PK.NEXTVAL,?)"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.executeQuery();
			System.out.println("Account created.");
			User a = new User(userID,password);
			viewUserAccount(a);
			sc.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void userLogin() throws IncorrectPasswordException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your user ID.");
		String userID = sc.next();
		System.out.println("Please enter your password.");
		String password = sc.next();
		User a = new User(userID, password);
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM USERS WHERE USER_ID = ? AND PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,userID);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.isBeforeFirst()) {
				throw new IncorrectPasswordException("Incorrect username or password. Please try again.");
			} else {
				viewUserAccount(a);
			}
			con.close();
			sc.close();
		} catch (IncorrectPasswordException e) {
			userLogin();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public static void viewUserAccount(User a) throws SQLException, IOException {
		System.out.println("Welcome to your dashboard!");
		System.out.println("");
		List<Account> accounts = getAccounts(a);
		System.out.println("Your current accounts are: "); 
		System.out.println("");
		for (int x = 0; x < accounts.size(); x++) {
			System.out.println(x+1 + ". Bank Account ID: " + accounts.get(x).getBankAccountID() + ", Balance: " + accounts.get(x).getBalance());
		}
		System.out.println("");
		System.out.println("To make a deposit, enter 1.");
		System.out.println("To withdraw an amount, enter 2.");
		System.out.println("To delete an account, enter 3. (Note: your account balance must be 0.)");
		System.out.println("To create another account, enter 4. (Maximum 5 accounts allowed.)");
		System.out.println("To logout, enter 5.");
			
		Scanner sc = new Scanner(System.in);
		String input = sc.next();	
		switch(input) {
			case "1" :
				deposit(a);
				break;
			case "2" :
				try {
					withdraw(a);
					break;
				} catch (OverdraftException e) {
					//loop
				}
			case "3" :
				deleteAccount(a);
				break;
			case "4" :
				createBankAccount(a);
				break;
			case "5" :
				logout();
				break;
			default :
				System.out.println("Invalid input. Please enter either 1, 2, 3, 4, or 5.");
				viewUserAccount(a);
			}
		sc.close();
	}
	
	public static void deposit(User a) throws SQLException, IOException {
		PreparedStatement pstmt = null;
		Account acct = null;
		List<Account> accounts = getAccounts(a);
		System.out.println("Your current accounts are: "); 
		for (int x = 0; x < accounts.size(); x++) {
			System.out.println(x+1 + ". Bank Account ID: " + accounts.get(x).getBankAccountID() + ", Balance: " + accounts.get(x).getBalance());
		}
		System.out.println("Which account would you like to deposit into?");
		Scanner sc = new Scanner(System.in);
		String accountIn = sc.next();
		switch(accountIn) {
			case "1":
				acct = accounts.get(0);
				bankAccountID = acct.getBankAccountID();
				break;
			case "2":
				acct = accounts.get(1);
				bankAccountID = acct.getBankAccountID();
				break;
			case "3":
				acct = accounts.get(2);
				bankAccountID =	acct.getBankAccountID();
				break;
			case "4":
				acct = accounts.get(3);
				bankAccountID = acct.getBankAccountID();
				break;
			case "5":
				acct = accounts.get(4);
				bankAccountID =	acct.getBankAccountID();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				deposit(a);	
		}				
		System.out.println("Enter the amount you would like to deposit.");
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			int depositAmt = sc.nextInt();
			String sql2 = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setDouble(1, acct.getBalance() + depositAmt);
			pstmt.setString(2, a.getID());
			pstmt.setString(3, bankAccountID);
			pstmt.executeQuery();
			System.out.println("Deposit successful. Your new balance is " + (acct.getBalance() + depositAmt) + ".");
			System.out.println("*********");
			con.close();
			viewUserAccount(a);			
		} catch (Exception e) {
			deposit(a);
		}
		sc.close();
	}
	
	public static void withdraw(User a) throws OverdraftException, SQLException, IOException {
		PreparedStatement pstmt = null;
		Account acct = null;
		List<Account> accounts = getAccounts(a);
		System.out.println("Your current accounts are: "); 
		for (int x = 0; x < accounts.size(); x++) {
			System.out.println(x+1 + ". Bank Account ID: " + accounts.get(x).getBankAccountID() + ", Balance: " + accounts.get(x).getBalance());
		}
		System.out.println("Which account would you like to withdraw from?");
		Scanner sc = new Scanner(System.in);
		String accountIn = sc.next();
		switch(accountIn) {
			case "1":
				acct = accounts.get(0);
				bankAccountID = acct.getBankAccountID();
				break;
			case "2":
				acct = accounts.get(1);
				bankAccountID = acct.getBankAccountID();
				break;
			case "3":
				acct = accounts.get(2);
				bankAccountID =	acct.getBankAccountID();
				break;
			case "4":
				acct = accounts.get(3);
				bankAccountID = acct.getBankAccountID();
				break;
			case "5":
				acct = accounts.get(4);
				bankAccountID =	acct.getBankAccountID();
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				deposit(a);	
		}				
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			System.out.println("Enter the amount you would like to withdraw.");
			int withdrawAmt = sc.nextInt();
			if (withdrawAmt > acct.getBalance()) {
				throw new OverdraftException("Insufficient funds. Please try again.");
			} else {
				String sql2 = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
				pstmt = con.prepareStatement(sql2);
				pstmt.setDouble(1, acct.getBalance()- withdrawAmt);
				pstmt.setString(2, a.getID());
				pstmt.setString(3, bankAccountID);
				pstmt.executeQuery();
				System.out.println("Withdrawal successful. Your new balance is " + (acct.getBalance() - withdrawAmt) + ".");
				System.out.println("*********");
				viewUserAccount(a);
			}			
		} catch (OverdraftException e) {
			withdraw(a);
		} 
		sc.close();
	}
	
	public static void deleteAccount(User a) throws SQLException, IOException {
		PreparedStatement pstmt = null;
		List<Account> accounts = getAccounts(a);
		Account acct;
		System.out.println("Your current accounts are: "); 
		for (int x = 0; x < accounts.size(); x++) {
			System.out.println(x+1 + ". Bank Account ID: " + accounts.get(x).getBankAccountID() + ", Balance: " + accounts.get(x).getBalance());
		}
		System.out.println("Which account would you like to delete?");
		Scanner sc = new Scanner(System.in);
		String accountIn = sc.next();
		switch(accountIn) {
			case "1":
				acct = accounts.get(0);
				bankAccountID = acct.getBankAccountID();
				if (acct.getBalance() > 0) {
					System.out.println("Cannot delete account with existing balance. Please withdraw all funds first.");
					viewUserAccount(a);
				}
				break;
			case "2":
				acct = accounts.get(1);
				bankAccountID = acct.getBankAccountID();
				if (acct.getBalance() > 0) {
					System.out.println("Cannot delete account with existing balance. Please withdraw all funds first.");
					viewUserAccount(a);
				}
				break;
			case "3":
				acct = accounts.get(2);
				bankAccountID = acct.getBankAccountID();
				if (acct.getBalance() > 0) {
					System.out.println("Cannot delete account with existing balance. Please withdraw all funds first.");
					viewUserAccount(a);
				}
				break;
			case "4":
				acct = accounts.get(3);
				bankAccountID = acct.getBankAccountID();
				if (acct.getBalance() > 0) {
					System.out.println("Cannot delete account with existing balance. Please withdraw all funds first.");
					viewUserAccount(a);
				}
				break;
			case "5":
				acct = accounts.get(4);
				bankAccountID = acct.getBankAccountID();
				if (acct.getBalance() > 0) {
					System.out.println("Cannot delete account with existing balance. Please withdraw all funds first.");
					viewUserAccount(a);
				}
				break;
			default:
				System.out.println("Invalid input. Please try again.");
				deposit(a);	
		}
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			System.out.println("Are you sure you want to delete your account? Y/N");
			String input = sc.next().toUpperCase();
			while (!input.equals("Y") && !input.equals("N")) {
				System.out.println("Invalid input. Please enter Y or N.");
				input = sc.next().toUpperCase();
			} if (input.equals("Y")) {
				String sql = "DELETE FROM ACCOUNTS WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, a.getID());
				pstmt.setString(2, bankAccountID);
				pstmt.executeQuery();
				System.out.println("Account deleted.");
				System.out.println("*********");
				viewUserAccount(a);
			} if (input.equals("N")) {
				viewUserAccount(a);
			}
			sc.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void createBankAccount(User a) throws SQLException, IOException {
		List<Account> accounts = getAccounts(a);
		if (accounts.size() >= 5) {
			System.out.println("Max account limit reached.");
			viewUserAccount(a);
		} else {
			PreparedStatement pstmt = null;
			try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
				String sql = "INSERT INTO ACCOUNTS VALUES(SQ_ACCOUNT_PK.NEXTVAL,?,0)"; 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, a.getID());
				pstmt.executeQuery();
				System.out.println("Account created.");
				con.close();
				viewUserAccount(a);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	public static void logout() {
		System.out.println("Thank you for using JDBC Bank.");
		System.exit(0);
	}
}
