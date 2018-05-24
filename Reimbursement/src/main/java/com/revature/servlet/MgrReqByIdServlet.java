package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.java.dao.MgrDao;
import com.revature.java.dao.MgrDaoImpl;
import com.revature.java.domain.Request;

/**
 * Servlet implementation class MgrInfoServlet
 */
public class MgrReqByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgrReqByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		if (session != null) {
			int userID = (int) session.getAttribute("userID");
			MgrDao m = new MgrDaoImpl();
			List<Request> r = m.viewByEmpId(userID);
			ObjectMapper om = new ObjectMapper();
			om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			String reqs = om.writeValueAsString(r);
			pw.write(reqs);
		} else {
			response.sendRedirect("homepage");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
