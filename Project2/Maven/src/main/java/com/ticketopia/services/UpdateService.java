package com.ticketopia.services;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.UserType;
import com.ticketopia.daos.CustomerInfoDao;
import com.ticketopia.daos.CustomerInfoDaoImpl;
import com.ticketopia.daos.PaymentInfoDao;
import com.ticketopia.daos.PaymentInfoDaoImpl;

public class UpdateService {
	//update email
	public static Boolean updateEmail(CustomerInfo customer, String email) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		customer.setUserEmail(email);
		return cid.updateCustomerInfo(customer);
	}
	
	//update payment
	public static Boolean updatePayment(PaymentInfo payment,
										Long cardNumber,
										Integer securityCode,
										String expirationDate,
										String billingAddress,
										String billingCity,
										String billingState,
										Integer billingZip) {
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		payment.setCardNumber(cardNumber);
		payment.setSecurityCode(securityCode);
		payment.setExpirationDate(expirationDate);
		payment.setBillingAddress(billingAddress);
		payment.setBillingCity(billingCity);
		payment.setBillingState(billingState);
		payment.setBillingZip(billingZip);
		return pid.updatePaymentInfo(payment);
	}
	
	//update points
	public static Boolean updatePoints(CustomerInfo customer, Ticket ticket, 
										Boolean smallDiscount, Boolean bigDiscount) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		UserType userType = customer.getRole();
		Double price = Math.floor(ticket.getTicketPrice());
		if (smallDiscount) {
			customer.setAccumulatedPoints(customer.getAccumulatedPoints()-5000);
		} else if (bigDiscount) {
			customer.setAccumulatedPoints(customer.getAccumulatedPoints()-10000);
		} else {
			if (userType.getRoleId() == 1) {
				customer.setAccumulatedPoints(customer.getAccumulatedPoints()+(int)(price*10));
			} else if (userType.getRoleId() == 2) {
				customer.setAccumulatedPoints(customer.getAccumulatedPoints()+(int)(price*25));
			}
			
		}
		return cid.updateCustomerInfo(customer);
	}
	//update role
	//update address
	//update password
	//update display name
	//update name
	//update post
	//update ticket price
	//update post title
}
