package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.BackEnd.EmployeeDao;
import com.revature.BackEnd.EmployeeDaoImpl;
import com.revature.domain.Reimburse;

/**
 * Servlet implementation class ViewOpenAeimbursementAll
 */
public class ViewOpenAeimbursementAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOpenAeimbursementAll() {
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
		PrintWriter pw = response.getWriter();

		ArrayList<Reimburse> rem = new ArrayList<>();

		try {
			EmployeeDao usr = new EmployeeDaoImpl();

			rem = usr.viewPendingReimburseAllInfo();

			for (Reimburse r : rem) {
				pw.println("<tr><td>" + r.getReimburseid() +"</td>"+"<td>" + r.getEmpID()+ "</td>"+ "</td>" + "<td>" + r.getAmount() + "</td>" + "<td>"
						+ r.getDescription() + "</td>" +  "<td>" + r.getSubmitted() + "</td>"+"<td>" + r.getResolved() + "</td>");
			}
			pw.print("</table>");
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		finally {
			pw.close();
		}

		pw.close();
	}

}
