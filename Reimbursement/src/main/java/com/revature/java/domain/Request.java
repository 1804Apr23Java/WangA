package com.revature.java.domain;

import java.util.Date;

public class Request {
	private int requestID;
	private int employeeID;
	private String comment;
	private int amount;
	private String receipt;
	private Date dateCreated;
	private int managerID;
	private String status;
	private Date dateResolved;
	
	public Request (int requestID, int employeeID, String comment, int amount, String receipt, Date dateCreated, int managerID, String status, Date dateResolved) {
		super();
		this.requestID = requestID;
		this.employeeID = employeeID;
		this.comment = comment;
		this.amount = amount;
		this.receipt = receipt;
		this.dateCreated = dateCreated;
		this.managerID = managerID;
		this.status = status;
		this.dateResolved = dateResolved;
	}
	
	public Request () {
		super();
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getRequestID() {
		return requestID;
	}
	
	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date dateResolved) {
		this.dateResolved = dateResolved;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Request [getReceipt()=" + getReceipt() + ", getDateCreated()=" + getDateCreated() + ", getRequestID()="
				+ getRequestID() + ", getEmployeeID()=" + getEmployeeID() + ", getAmount()=" + getAmount()
				+ ", getDateResolved()=" + getDateResolved() + ", getManagerID()=" + getManagerID() + ", getStatus()="
				+ getStatus() + "]";
	}
}
