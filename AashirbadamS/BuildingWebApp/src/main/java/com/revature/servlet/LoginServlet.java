package com.revature.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revature.BackEnd.EmployeeDao;
import com.revature.BackEnd.EmployeeDaoImpl;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		javax.servlet.http.HttpSession session = request.getSession();
		response.setContentType("text/html");
		EmployeeDao ed = new EmployeeDaoImpl();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		EmployeeDaoImpl r = new EmployeeDaoImpl();
		String role = r.getUserRole(username, password);
		response.setContentType("text/html");
		try {

			if (ed.login(username, password).equals("manager")) {
				session.setAttribute("username", username);
				session.setAttribute("problem", null);
				response.sendRedirect("ManagerHome.html");

			} else if (ed.login(username, password).equals("employee")) {
				session.setAttribute("username", username);
				session.setAttribute("problem", null);
				System.out.println();
				response.sendRedirect("EmployeeHome.html");

			} else {
				session.setAttribute("problem", "incorrect password");
				response.sendRedirect("index.html");
				System.out.println("Invalid");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid Username");
			 PrintWriter pw = response.getWriter();
			pw.print("<tr><td>" + "<li>  Invalid Creds!!  </li>" + "</td>" );						
			pw.print("</table>");
			response.sendRedirect("index.html");
		}

	}
}
