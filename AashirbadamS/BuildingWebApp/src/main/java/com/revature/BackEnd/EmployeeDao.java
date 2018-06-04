package com.revature.BackEnd;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;


import com.revature.domain.Employee;
import com.revature.domain.Reimburse;

public interface EmployeeDao {
	
	public int getUsername(String username);
	public String getPassword (String password);
	public String getUserRole(String username,String password);
	public String updatepassword(String username, String password);
	public String login(String username, String password);
	public Employee viewInfo(String Username);
	
	//public void updateInfo(Employee e);
	public void updateInfo(Employee e,String username);
	public String resetpassword (String username,String password);
	//Reimbursement
	public void submitReimbursement(String username, Reimburse r);
	public ArrayList <Reimburse> viewSubmittedReimburseInfo(String username) ;
	public ArrayList<Reimburse> viewPendingReimburseInfo(String username) ;
	public ArrayList<Reimburse> viewClosedReimburseInfo(String username);
	
	//Manager
	public ArrayList<Employee> viewEmployees() throws SQLException ;
	public ArrayList<Reimburse> viewClosedReimburseAllInfo();
	public ArrayList<Reimburse> viewPendingReimburseAllInfo();
	public void approveReimburse(Reimburse r,String status, int reimbid);
	
	public void updateInfoManager(String username, String password);
	
	public ArrayList<Reimburse> viewPendingReimburseperUser(String username);
	
	public void registerUser(String firstname, String lastname, String role,String username, String password);
	
	
	
}
