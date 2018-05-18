package com.revature.java.jdbc;

import java.util.Scanner;
import com.revature.util.jdbc.ConnectionTest;
import java.io.IOException;
import java.sql.*;

public class Console {
	public static void main(String[] args) throws IncorrectPasswordException {
		try {
			Connection con = ConnectionTest.getConnectionFromFile("dbconnection.properties");
			System.out.println(con.toString());	
				Scanner sc = new Scanner(System.in);
				System.out.println("Welcome to JDBC Bank. Please select an option by entering 1 or 2: ");
				System.out.println("1. User Login");
				System.out.println("2. Superuser Login");
				System.out.println("3. Create Account");	
				String input = sc.next();
			while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
				System.out.println("Invalid input. Please enter 1, 2, or 3.");
				input = sc.next();
			} if (input.equals("1")) {
				UserDaoImpl.userLogin();
			} if (input.equals("2")) {
				//superuser
			} if (input.equals("3")) {
				UserDaoImpl.createUserAccount();
			}
			sc.close();
			con.close();
		} catch (IncorrectPasswordException e) {
			System.out.println("Incorrect username or password. Please try again.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

