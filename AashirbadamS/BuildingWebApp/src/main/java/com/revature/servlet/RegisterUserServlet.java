package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDao;
import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;

/**
 * Servlet implementation class RegisterUserServlet
 */
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
		//PrintWriter pw = response.getWriter();

		Employee e = new Employee();

		String uName = (String) session.getAttribute("username");
		System.out.println(uName);

		try {
			EmployeeDao ed = new EmployeeDaoImpl();
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String role = request.getParameter("role");
			String password = request.getParameter("password");
			ed.registerUser(firstname, lastname, role,username, password);
			response.sendRedirect("http://localhost:8089/BuildingWebApp/ViewAllEmployeePage.html");
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
		
		
		
	

}
