package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Reimburse;

/**
 * Servlet implementation class ReimburseSubmit
 */
public class ReimburseSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReimburseSubmit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		response.setContentType("text/html");

		Employee e = new Employee();
		Reimburse r = new Reimburse();

		String uName = (String) session.getAttribute("username");
		System.out.println(uName);
		try {
			EmployeeDaoImpl usr = new EmployeeDaoImpl();
			if (request.getParameter("amount") != null) {
				System.out.println(request.getParameter("amount"));
				r.setAmount(Double.parseDouble(request.getParameter("amount")));
			} else
				r.setAmount(0);
			if (request.getParameter("description") != null) {
				r.setDescription(request.getParameter("description"));
			} else
				r.setDescription(null);

			if (request.getParameter("status") != null) {
				r.setStatus(request.getParameter("status"));
			} else
				r.setDescription(null);

			e.setUsername(uName);
			usr.submitReimbursement(uName, r);
			response.sendRedirect("SubmitReimbursement.html");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
