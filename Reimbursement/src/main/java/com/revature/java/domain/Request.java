package com.revature.java.domain;

import java.util.Date;

public class Request {
	private static int requestID;
	private static int employeeID;
	private static String comment;
	private static int amount;
	private static String receipt;
	private static Date dateCreated;
	private static int managerID;
	private static String status;
	private static Date dateResolved;
	
	public Request (int requestID, int employeeID, String comment, int amount, String receipt, Date dateCreated, int managerID, String status, Date dateResolved) {
		super();
		Request.requestID = requestID;
		Request.employeeID = employeeID;
		Request.comment = comment;
		Request.amount = amount;
		Request.receipt = receipt;
		Request.dateCreated = dateCreated;
		Request.managerID = managerID;
		Request.status = status;
		Request.dateResolved = dateResolved;
	}
	
	public Request () {
		super();
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		Request.comment = comment;
	}
	
	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		Request.receipt = receipt;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		Request.dateCreated = dateCreated;
	}

	public int getRequestID() {
		return requestID;
	}
	
	public void setRequestID(int requestID) {
		Request.requestID = requestID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) {
		Request.employeeID = employeeID;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		Request.amount = amount;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		Request.dateResolved = dateResolved;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		Request.managerID = managerID;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		Request.status = status;
	}

	@Override
	public String toString() {
		return "Request [getReceipt()=" + getReceipt() + ", getDateCreated()=" + getDateCreated() + ", getRequestID()="
				+ getRequestID() + ", getEmployeeID()=" + getEmployeeID() + ", getAmount()=" + getAmount()
				+ ", getDateResolved()=" + getDateResolved() + ", getManagerID()=" + getManagerID() + ", getStatus()="
				+ getStatus() + "]";
	}
}
