package com.revature.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.RequestHelper;

public class MasterServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    public MasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/MainHomepage.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userID = Integer.parseInt(request.getParameter("userID"));
		String password = request.getParameter("password");
		String destination = RequestHelper.userLogin(userID, password);
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		if (destination.equals("employee") || destination.equals("manager")) {
			session.setAttribute("userID", userID);
		} else {
			session.setAttribute("problem", "incorrect login");
		}
		response.sendRedirect(destination);
	}
}
