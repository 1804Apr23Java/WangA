package com.revature.java.jdbc;

public class User {
	private static String userID;
	private static String password;
	
	public User(String userID, String password) {
		super();
		User.userID = userID;
		this.setPassword(password);
	}
	
	public String getID() {
		return userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		User.password = password;
	}
}
