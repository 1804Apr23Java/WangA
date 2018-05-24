package com.revature.java.dao;

import java.util.List;

import com.revature.java.domain.Employee;
import com.revature.java.domain.Request;

public interface EmpDao {
	public boolean empLogin(int empID, String password);
	public void submitRequest(int empID, Request r);
	public List<Request> viewPending(int empID);
	public List<Request> viewResolved(int empID);
	public Employee viewEmpInfo(int empID);
	public void updateInfo(int empID);
}
