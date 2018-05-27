package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.java.dao.MgrDao;
import com.revature.java.dao.MgrDaoImpl;

/**
 * Servlet implementation class ApproveReqServlet
 */
public class ApproveReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveReqServlet() {
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
		System.out.println("HERE");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("userID") != null) {
			String requestID = request.getParameter("id");
			int reqID = Integer.parseInt(requestID);
			String userID = (String) session.getAttribute("userID");
			int mgrID = Integer.parseInt(userID);
	        MgrDao m = new MgrDaoImpl();
	       	m.approveRequest(reqID, mgrID);     
	       	request.getRequestDispatcher("/views/ManagerHomepage.html").forward(request, response);
		} else {
			response.sendRedirect("homepage");
		}
	}
}
