package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;

/**
 * Servlet implementation class UpdateInfoServletManager
 */
public class UpdateInfoServletManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServletManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		

		Employee e = new Employee();

		try {
			EmployeeDaoImpl usr = new EmployeeDaoImpl();

		   usr.updateInfoManager(request.getParameter("username"),request.getParameter("password"));
		response.sendRedirect("ViewAllEmployeePage.html");
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}

}
