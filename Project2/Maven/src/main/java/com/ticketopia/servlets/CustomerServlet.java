package com.ticketopia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketopia.beans.CustomerInfo;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
		Algorithm algorithm = Algorithm.HMAC256("secretPassword123");
		JWTVerifier verifier = JWT.require(algorithm).withIssuer("Shadow").build();
		DecodedJWT jwt = verifier.verify(token);
		CustomerInfo ci = new CustomerInfo(jwt.getClaim("userEmail").asString(), jwt.getClaim("displayName").asString(), jwt.getClaim("userFName").asString(), jwt.getClaim("userLName").asString(), jwt.getClaim("accumulatedPoints").asInt(), jwt.getClaim("role").asInt(), jwt.getClaim("userAddress").asString(), jwt.getClaim("userCity").asString(), jwt.getClaim("userState").asString(), jwt.getClaim("userZip").asInt(), null);
		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		System.out.println(ci);
		out.print(om.writeValueAsString(ci));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
