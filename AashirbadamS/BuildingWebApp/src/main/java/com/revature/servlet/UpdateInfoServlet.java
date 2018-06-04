package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;

/**
 * Servlet implementation class UpdateInfoServlet
 */
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		//PrintWriter pw = response.getWriter();

		Employee e = new Employee();

		String uName = (String) session.getAttribute("username");
		System.out.println(uName);

		try {
			EmployeeDaoImpl usr = new EmployeeDaoImpl();
			if (request.getParameter("username") != null) {
				System.out.println(request.getParameter("username"));
				e.setFirstName(request.getParameter("username"));
			} else
				e.setFirstName(null);
			if (request.getParameter("firstName") != null) {
				System.out.println(request.getParameter("firstName"));
				e.setFirstName(request.getParameter("firstName"));
			} else
				e.setFirstName(null);
			if (request.getParameter("lastName") != null) {
				e.setLastName(request.getParameter("lastName"));
			} else
				e.setLastName(null);			
			//e.setUsername(uName);//change was made here
			usr.updateInfo(e,uName);
			response.sendRedirect("EmployeeHome.html");
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
}

