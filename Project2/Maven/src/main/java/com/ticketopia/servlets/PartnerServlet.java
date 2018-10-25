package com.ticketopia.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketopia.beans.Partner;
import com.ticketopia.daos.PartnerDao;
import com.ticketopia.daos.PartnerDaoImpl;

/**
 * Servlet implementation class PartnerServlet
 */
public class PartnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PartnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PartnerDao pd = new PartnerDaoImpl();
		List<Partner> partners = pd.getAllPartner();
		
		ObjectMapper om = new ObjectMapper();
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(om.writeValueAsString(partners));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
