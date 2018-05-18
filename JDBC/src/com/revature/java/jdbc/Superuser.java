package com.revature.java.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.util.jdbc.ConnectionTest;

public class Superuser {
	private static String filename = "dbconnection.properties";
	private static String userID;
	private static String password;
	private static String superuserID;
	private static String superPassword;
	
	public Superuser(String superuserID, String superPassword) {
		super();
		Superuser.superuserID = superuserID;
		this.setPassword(superPassword);
	}
	
	public String getID() {
		return superuserID;
	}

	public String getSuperPassword() {
		return superPassword;
	}
	
	public void setPassword(String superPassword) {
		Superuser.superPassword = superPassword;
	}
	
	public static void createSuperUser() throws SQLException, IOException {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a password.");
			String superPassword = sc.nextLine();
			String sql = "INSERT INTO SUPERUSER VALUES(SUPERUSER_SEQ.NEXTVAL,?)"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, superPassword);
			pstmt.executeQuery();
			System.out.println("Account created. Your username is ");
			User a = new User(userID,password);
			viewUser(a);
			sc.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<User> getUsers() throws SQLException, IOException {
		List<User> userList = new ArrayList<>();
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM USERS";
			Statement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String userID = rs.getString("USER_ID");
				String acctID = rs.getString("BANK_ACCOUNT_ID");
				double balance = rs.getDouble("BALANCE");
				userList.add(new User(userID, acctID));
			}
			return userList;
		}
	}
	
	public static void viewUser(User a) throws SQLException, IOException {
		try(Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM USERS WHERE USER_ID = " + a.getID();
			Statement stmt = con.prepareStatement(sql);
			
		}
	}
	
	public static void createUser() throws SQLException, IOException {
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a password.");
			String password = sc.nextLine();
			String sql = "INSERT INTO USERS VALUES(USERS_SEQ.NEXTVAL,?)"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.executeQuery();
			System.out.println("Account created.");
			User a = new User(userID,password);
			viewUser(a);
			sc.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateUser(User a) throws SQLException, IOException {
		try(Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			PreparedStatement p = con.prepareStatement("UPDATE USER SET PASSWORD = ? WHERE USERID = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(User a) throws SQLException, IOException {
		try(Connection con = ConnectionTest.getConnectionFromFile(filename)) {
			PreparedStatement p = con.prepareStatement("DELETE FROM USER WHERE USERID = ?");
		}
	}
}