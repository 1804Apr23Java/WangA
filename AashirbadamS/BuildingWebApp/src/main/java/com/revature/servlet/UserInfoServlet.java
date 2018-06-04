package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDao;
import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;

/**
 * Servlet implementation class UserInfoServlet
 */
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
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
				          
		String uName = (String) session.getAttribute("username");
		System.out.println(uName);
		          
		try{  	   		
			EmployeeDaoImpl usr = new EmployeeDaoImpl();			
			e = usr.viewInfo(uName);
			System.out.println(e.getFirstName());
			System.out.println(e.getLastName());
			System.out.println(e.getUsername());
			System.out.println(e.getRole());
			
			pw.print("<tr><td>" + e.getFirstName() + "</td>" + 
					"<td>" + e.getLastName() + "</td>" +
					"<td>" + e.getUsername()+ "</td> " + 
					"<td>" + e.getRole() + "</td>");			
			
			pw.print("</table>");
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


