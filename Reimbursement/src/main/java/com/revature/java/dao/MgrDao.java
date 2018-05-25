package com.revature.java.dao;

import java.util.List;

import com.revature.java.domain.Employee;
import com.revature.java.domain.Manager;
import com.revature.java.domain.Request;

public interface MgrDao {
	public boolean mgrLogin(int mgrID, String password);
	public Manager mgrInfo(int mgrID);
	public List<Employee> getEmployees();
	public void approveRequest(int requestID);
	public void denyRequest(int requestID);
	public List<Request> viewPending();
	public List<Request> viewResolved();
	public List<Request> viewByEmpId(int id);
}
