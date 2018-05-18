package com.revature.java.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	public static List<Account> getAccounts(User a) {
		return null;
	}
	public static void createUserAccount() {
	}
	
	public static void userLogin() throws IncorrectPasswordException {
	}
	
	public static void viewUserAccount(User a) throws SQLException, IOException {
	}
	
	public static void deposit(User a) throws SQLException, IOException {
	}
	
	public static void withdraw(User a) throws OverdraftException, SQLException, IOException {
	}
	
	public static void deleteAccount(User a) throws SQLException, IOException {
	}
	
	public static void createBankAccount(User a) throws SQLException, IOException {
	}
	
	public static void logout() {
	}
}
