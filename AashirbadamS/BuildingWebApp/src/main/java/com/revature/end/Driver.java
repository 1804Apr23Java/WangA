package com.revature.end;

import java.io.IOException;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.BackEnd.EmployeeDao;
import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Reimburse;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args) {
		EmployeeDao ed = new EmployeeDaoImpl();
		Employee e2 = new Employee();
		Reimburse r = new Reimburse();
		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
			
	/*		String name = "shivam";
			String username = "j.malik@gmail.com";
			String password ="test123";
			String lastname="malik";
			int j = ed.getUsername(username);
			System.out.println(j);
			System.out.println(ed.getUserRole(username,password));
			System.out.println(ed.getPassword(username));
			System.out.println(ed.login(username, password));
			System.out.println(ed.updateInfo(e2.setFirstName(name)));
			ed.resetpassword(username,lastname,password);
			System.out.println(ed.resetpassword(username,lastname,password));*/
			
	/*		r.setAmount(30);
			r.setDescription("food");
			r.setStatus("open");			
			ed.submitReimbursement("j.malik@gmail.com", r);*/
			
/*			String username="j.malik@gmail.com";
			ArrayList<Reimburse> data = new ArrayList<Reimburse>();
			data = ed.viewSubmittedReimburseInfo(username);
			for(Reimburse d :data) {
				System.out.println(d.getAmount()+" " + d.getDescription()+" "+ d.getSubmitted());
			}
			*/
	/*		
			String username="j.malik@gmail.com";
			ArrayList<Reimburse> status = new ArrayList<Reimburse>();
			status = ed.viewPendingReimburseInfo(username);
			for(Reimburse d :status) {
				//System.out.println(d.getAmount()+" " + d.getDescription()+" "+ d.getSubmitted());
				System.out.println(d.getAmount()+" "+d.getDescription());
			}*/

			
		/*	String username="j.malik@gmail.com";
			ArrayList<Reimburse> status = new ArrayList<Reimburse>();
			status = ed.viewClosedReimburseInfo(username);
			for(Reimburse d :status) {
				//System.out.println(d.getAmount()+" " + d.getDescription()+" "+ d.getSubmitted());
				System.out.println(d.getAmount()+" "+d.getDescription());
			}*/
		
			/*ArrayList<Employee> emp = new ArrayList<Employee>();
			emp=ed.viewEmployees();			
			for(Employee e: emp) {
				System.out.println(e.getFirstName());
			}*/
			
		/*	ArrayList<Reimburse> re = new ArrayList<Reimburse>();
			re = ed.viewClosedReimburseAllInfo();			
			for(Reimburse e: re) {
				System.out.println(e.getAmount());
			}*/
			
		
					
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
