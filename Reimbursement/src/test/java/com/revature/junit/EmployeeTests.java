package com.revature.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.revature.java.dao.EmpDao;
import com.revature.java.dao.EmpDaoImpl;
import com.revature.java.domain.Employee;
import com.revature.java.domain.Request;

public class EmployeeTests {
	
	EmpDao emp = new EmpDaoImpl();
	List<Request> r = new ArrayList<Request>();

	@Test
	public void testEmpLogin() {
		boolean check = emp.empLogin(1200,"cm2018");
		assertEquals(true, check);
	}
	
	@Test
	public void testFailedEmpLogin() {
		boolean check = emp.empLogin(1,"password");
		assertEquals(false, check);
	}
	
	@Test
	public void testViewEmpInfo() {
		Employee e = emp.viewEmpInfo(1200);
		assertEquals(1200, e.getEmployeeID());
		assertEquals("Collin", e.getFirstName());
		assertEquals("Meaney", e.getLastName());
	}
	
	@Test
	public void testSubmitRequest() {
		
		
	}
	
	@Test
	public void testViewPendingRequests() {
		r = emp.viewPending(1200);
		System.out.println(r);
		Assert.assertNotNull(r);
	}
	
	@Test
	public void testViewResolvedRequests() {
		//expect list of Requests
	}
}
