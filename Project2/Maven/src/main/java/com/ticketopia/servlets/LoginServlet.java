package com.ticketopia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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
		System.out.println(email + password);
		CustomerInfo loggingInUser = cid.getCustomerByEmail(email.toLowerCase());
		if(loggingInUser != null) {
			if(loggingInUser.getPassword().equals(password)) {
				Algorithm algorithmHS = Algorithm.HMAC256("secretPassword123");
				String token = JWT.create().withIssuer("Shadow").withClaim("userEmail", loggingInUser.getUserEmail())
						.withClaim("displayName", loggingInUser.getDisplayName())
						.withClaim("userFName", loggingInUser.getUserFName())
						.withClaim("userLName", loggingInUser.getUserLName())
						.withClaim("accumulatedPoints", loggingInUser.getAccumulatedPoints())
						.withClaim("userAddress", loggingInUser.getUserAddress())
						.withClaim("userCity", loggingInUser.getUserCity())
						.withClaim("userState", loggingInUser.getUserState())
						.withClaim("userZip", loggingInUser.getUserZip())
						.sign(algorithmHS);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print(token);
				System.out.println(token);
				//RequestDispatcher rd = request.getRequestDispatcher("");
				//rd.forward(request, response);
				return;
			} else {
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				ObjectMapper om = new ObjectMapper();
				out.print(om.writeValueAsString("wrong info"));
			}
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ObjectMapper om = new ObjectMapper();
		out.print(om.writeValueAsString(loggingInUser));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
