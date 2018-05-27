package com.revature.junit;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import com.revature.java.dao.MgrDao;
import com.revature.java.dao.MgrDaoImpl;
import com.revature.java.domain.Employee;
import com.revature.java.domain.Manager;
import com.revature.java.domain.Request;

public class ManagerTests {

	MgrDao m = new MgrDaoImpl();
	
	@Test
	public void testMgrLogin() {
		boolean check = m.mgrLogin(1311,"aw2018");
		assertEquals(true, check);
	}
	
	@Test
	public void testFailedMgrLogin() {
		boolean check = m.mgrLogin(1,"password");
		assertEquals(false, check);
	}
	
	@Test
	public void testGetEmployees() {
		List<Employee> result = m.getEmployees();
		System.out.println(result.get(0).getEmployeeID());
		System.out.println(result.get(1).getEmployeeID());
		Assert.assertNotNull("List shouldn't be null", result);
		Assert.assertEquals("2 Employees exist", 2, result.size());
	}
	
	@Test
	public void testViewPendingRequests() {
		List<Request> result = m.viewPending();
		Assert.assertNotNull(result);
		Assert.assertEquals("1 pending request", 1, result.size());
	}
	
	@Test
	public void testViewResolvedRequests() {
		List<Request> result = m.viewResolved();
		System.out.println(result.get(0).toString());
		System.out.println(result.get(1).toString());
		Assert.assertNotNull(result);
		Assert.assertEquals("3 resolutions exist", 3, result.size());
	}
	
	@Test
	public void testViewRequestsById() {
		List<Request> result = m.viewByEmpId(1200);
		System.out.println(result.get(0).getRequestID());
		System.out.println(result.get(1).getRequestID());
		Assert.assertNotNull(result);
		Assert.assertEquals("2 requests exist", 2, result.size());
	}
	
	@Test
	public void testMgrInfo() {
		Manager mgr = m.mgrInfo(1311);
		Assert.assertNotNull(mgr);
		Assert.assertEquals("Angela", mgr.getFirstName());
		Assert.assertEquals("Wang", mgr.getLastName());
		Assert.assertEquals(1311, mgr.getManagerID());
	}

}
