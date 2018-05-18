package com.revature.java.jdbc;

public class Account {
	private String userID;
	private String bankAccountID;
	private double balance;
	public Account(String userID,  String bankAccountID, double balance) {
		super();
		this.setUserID(userID);
		this.setBankAccountID(bankAccountID);
		this.setBalance(balance);
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBankAccountID() {
		return bankAccountID;
	}
	public void setBankAccountID(String bankAccountID) {
		this.bankAccountID = bankAccountID;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}	
