package com.ticketopia.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.daos.PaymentInfoDao;
import com.ticketopia.daos.PaymentInfoDaoImpl;

/**
 * Servlet implementation class PaymentInfoServlet
 */
public class PaymentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		PaymentInfo pi = om.convertValue(request.getParameter("payment"), PaymentInfo.class);
		boolean update = om.convertValue(request.getParameter("update"), Boolean.class);
		boolean success;
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		if(update) {
			success = pid.updatePaymentInfo(pi);
		} else {
			success = pid.insertNewPaymentInfo(pi);
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(om.writeValueAsString(success));
		
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
