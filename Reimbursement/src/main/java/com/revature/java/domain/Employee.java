package com.revature.java.domain;

public class Employee {
	private static int employeeID;
	private static String firstName;
	private static String lastName;
	private static String password;
	private static String email;
	
	public Employee(int employeeID, String firstName, String lastName, String password, String email) {
		super();
		Employee.employeeID = employeeID;
		Employee.firstName = firstName;
		Employee.lastName = lastName;
		Employee.password = password;
		Employee.email = email;
	}

	public static int getEmployeeID() {
		return employeeID;
	}

	public static void setEmployeeID(int employeeID) {
		Employee.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		Employee.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		Employee.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Employee.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Employee.email = email;
	}
	
}
