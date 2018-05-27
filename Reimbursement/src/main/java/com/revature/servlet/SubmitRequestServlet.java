package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.java.dao.EmpDao;
import com.revature.java.dao.EmpDaoImpl;
import com.revature.java.domain.Request;

/**
 * Servlet implementation class SubmitRequestServlet
 */
public class SubmitRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userID") != null) {
			int userID = (int) session.getAttribute("userID");
	        String comment = request.getParameter("comment");  
	        String amount = request.getParameter("amount");
	        int amt = Integer.parseInt(amount);
	        Request r = new Request();
	        r.setEmployeeID(userID);
	        r.setComment(comment);
	        r.setAmount(amt);
	        EmpDao e = new EmpDaoImpl();
	        e.submitRequest(userID, r);       
	        request.getRequestDispatcher("/views/EmployeeHomepage.html").forward(request, response);
		} else {
			response.sendRedirect("homepage");
		}
	}
}