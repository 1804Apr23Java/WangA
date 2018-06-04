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
 * Servlet implementation class ApproveReimburseServlet
 */
public class ApproveReimburseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveReimburseServlet() {
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
		// PrintWriter pw = response.getWriter();

		Reimburse r = new Reimburse();

		String uName = (String) session.getAttribute("username");
		System.out.println(uName);
		
		String status = request.getParameter("Status");
		int requestid= Integer.parseInt(request.getParameter("RequestID"));
		

		try {
			EmployeeDaoImpl usr = new EmployeeDaoImpl();
			usr.approveReimburse(r,status,requestid);
			response.sendRedirect("AllpendingReimburse.html");

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
}

