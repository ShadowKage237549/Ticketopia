package com.ticketopia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.daos.CustomerInfoDao;
import com.ticketopia.daos.CustomerInfoDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		String displayName = request.getParameter("displayName");
		String userFName = request.getParameter("userFName");
		String userLName = request.getParameter("userLName");
		Integer accumulatedPoints = 0;
		Integer role = Integer.parseInt(request.getParameter("role"));
		String userAddress = request.getParameter("userAddress");
		String userCity = request.getParameter("userCity");
		String userState = request.getParameter("userState");
		Integer userZip = Integer.parseInt(request.getParameter("userZip"));
		if(role == 1) {
			CustomerInfo customer = new CustomerInfo(userEmail, displayName, userFName, userLName, accumulatedPoints, role, userAddress, userCity, userState, userZip, password);
			CustomerInfoDao cid = new CustomerInfoDaoImpl();
			cid.createCustomer(customer);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
