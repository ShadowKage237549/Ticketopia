package com.ticketopia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketopia.beans.PostTitle;
import com.ticketopia.daos.PostTitleDao;
import com.ticketopia.daos.PostTitleDaoImpl;

/**
 * Servlet implementation class CreatePostTitleServlet
 */
public class CreatePostTitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreatePostTitleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		Integer topicId = Integer.parseInt(request.getParameter("id"));

		PostTitle pt = new PostTitle(0, topicId, title);
		PostTitleDao ptd = new PostTitleDaoImpl();
		Integer id = ptd.createPostTitle(pt);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		ObjectMapper om = new ObjectMapper();
		out.print(om.writeValueAsString(id));
		
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
