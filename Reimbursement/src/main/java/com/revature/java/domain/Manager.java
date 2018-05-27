package com.revature.java.domain;

public class Manager {
	private int managerID;
	private String firstName;
	private String lastName;
	private String password;
	
	public Manager(int managerID, String firstName, String lastName, String password) {
		super();
		this.managerID = managerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public Manager() {
		super();
	}

	public int getManagerID() {
		return managerID;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
