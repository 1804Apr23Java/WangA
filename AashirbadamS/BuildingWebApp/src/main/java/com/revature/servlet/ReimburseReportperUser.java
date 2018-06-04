package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Reimburse;

/**
 * Servlet implementation class ReimburseReportperUser
 */
public class ReimburseReportperUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimburseReportperUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();		
		
		Employee e = new Employee();
		ArrayList<Reimburse> data = new ArrayList<Reimburse>();
		String username = request.getParameter("username");
		          
		try{  	   		
			EmployeeDaoImpl usr = new EmployeeDaoImpl();			
			data = usr.viewSubmittedReimburseInfo(username);
		 for(Reimburse r :data)	
		 {	
			System.out.println(r.getAmount());
			
			pw.print("<h3> Submitted Reimbursement<h3>");
			pw.print("<tr><td>" + "<li>" +  r.getAmount()+  r.getDescription() +r.getStatus() +"</li>"  + "</td>" );						
			pw.print("</table>");
		
		}
		}
		catch (Exception e2) 
		{
			e2.printStackTrace();
		}  
		          
		finally
		{
			pw.close();
		}  

		pw.close();
	}
	}


