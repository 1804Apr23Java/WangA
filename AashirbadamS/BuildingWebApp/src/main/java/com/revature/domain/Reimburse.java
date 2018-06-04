package com.revature.domain;

import java.security.Timestamp;
import java.sql.Blob;
import java.time.temporal.Temporal;

public class Reimburse {
	private int reimburseid;
	private double amount;
	private String description;
	private String status;
	private java.sql.Timestamp submitted;
	private String resolved;
	private Blob receipt;
	private int empID;

	public Reimburse() {
		super();
	}

	public int getReimburseid() {
		return reimburseid;
	}

	public void setReimburseid(int reimburseid) {
		this.reimburseid = reimburseid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReceipt() {
		return receipt;
	}

	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.sql.Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(java.sql.Timestamp submitted) {
		this.submitted = submitted;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}



}
