package com.ticketopia.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();

		RequestDispatcher rd;

		String[] tokens = uri.split("/");
		String action = (tokens[tokens.length - 1]);
		action = action.substring(0, action.length() - 3).toLowerCase();
		System.out.println(action);
		switch (action) {
		case "register":
			rd = request.getRequestDispatcher("/RegisterServlet");
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
		case "ticket":
			rd = request.getRequestDispatcher("/TicketServlet");
			rd.forward(request, response);
			break;
		case "tickets":
			rd = request.getRequestDispatcher("/TicketsServlet");
			rd.forward(request, response);
			break;
		case "partner":
			rd = request.getRequestDispatcher("/PartnerServlet");
			rd.forward(request, response);
			break;
		case "topic":
			rd = request.getRequestDispatcher("/TopicServlet");
			rd.forward(request, response);
			break;
		case "topics":
			rd = request.getRequestDispatcher("/TopicsServlet");
			rd.forward(request, response);
			break;
		case "customerinfo":
			rd = request.getRequestDispatcher("/CustomerServlet");
			rd.forward(request, response);
			break;
		case "posttitle":
			rd = request.getRequestDispatcher("/PostTitleServlet");
			rd.forward(request, response);
			break;
		case "createposttitle":
			rd = request.getRequestDispatcher("/CreatePostTitleServlet");
			rd.forward(request, response);
			break;
		case "post":
			rd = request.getRequestDispatcher("/PostServlet");
			rd.forward(request, response);
			break;
		case "posts":
			rd = request.getRequestDispatcher("/PostsServlet");
			rd.forward(request, response);
			break;
		case "updatepayment":
			rd = request.getRequestDispatcher("/PaymentInfoServlet");
			rd.forward(request, response);
			break;
		case "payment":
			rd = request.getRequestDispatcher("/PaymentServlet");
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
