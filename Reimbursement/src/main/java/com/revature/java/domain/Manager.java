package com.revature.java.domain;

public class Manager {
	private static int managerID;
	private static String firstName;
	private static String lastName;
	private static String password;
	
	public Manager(int managerID, String firstName, String lastName, String password) {
		super();
		Manager.managerID = managerID;
		Manager.firstName = firstName;
		Manager.lastName = lastName;
		Manager.password = password;
	}

	public static int getManagerID() {
		return managerID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		Manager.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		Manager.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Manager.password = password;
	}
}
