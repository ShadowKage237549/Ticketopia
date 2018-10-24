package com.ticketopia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.daos.CustomerInfoDao;
import com.ticketopia.daos.CustomerInfoDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email, password;
		email = request.getParameter("email");
		password = request.getParameter("password");
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		CustomerInfo loggingInUser = null;
		loggingInUser = cid.getCustomerByEmail(email);
		if(!(loggingInUser == null)) {
			if(loggingInUser.getPassword().equals(password)) {
				ObjectMapper om = new ObjectMapper();
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.println(om.writeValueAsString(loggingInUser));
				RequestDispatcher rd = request.getRequestDispatcher("");
				rd.forward(request, response);
				return;
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Incorrect Information");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
