package com.ticketopia.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispactherServlet
 */
public class DispactherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DispactherServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer url = request.getRequestURL();
		System.out.println(url.toString());
		String uri = request.getRequestURI();
		System.out.println(uri);

		RequestDispatcher rd;

		String[] tokens = uri.split("/");
		String action = (tokens[tokens.length - 1]);
		action = action.substring(0, action.length() - 3).toLowerCase();
		System.out.println(action);

		switch (action) {
		case "register":
			rd = request.getRequestDispatcher("/RegisterUser");
			rd.forward(request, response);
			break;
		case "login":
			rd = request.getRequestDispatcher("/LoginServlet");
			rd.forward(request, response);
			break;
		case "logout":
			rd = request.getRequestDispatcher("/LogoutServlet");
			rd.forward(request, response);
			break;
		case "tickets":
			rd = request.getRequestDispatcher("/TicketServlet");
			rd.forward(request, response);
			break;
		default:
			response.sendError(404);
			break;
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
