package com.ticketopia.services;

import java.util.ArrayList;
import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.Post;
import com.ticketopia.beans.PostTitle;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.UserType;
import com.ticketopia.daos.CustomerInfoDao;
import com.ticketopia.daos.CustomerInfoDaoImpl;
import com.ticketopia.daos.PaymentInfoDao;
import com.ticketopia.daos.PaymentInfoDaoImpl;
import com.ticketopia.daos.PostDao;
import com.ticketopia.daos.PostDaoImpl;
import com.ticketopia.daos.PostTitleDao;
import com.ticketopia.daos.PostTitleDaoImpl;
import com.ticketopia.daos.TicketDao;
import com.ticketopia.daos.TicketDaoImpl;
import com.ticketopia.daos.UserTypeDao;
import com.ticketopia.daos.UserTypeDaoImpl;

public class UpdateService {
	//update email
	public Boolean updateEmail(CustomerInfo customer, String email) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		List<PaymentInfo> payments = pid.getPayments();
		PaymentInfo payment = null;
		
		for(PaymentInfo p: payments) {
			if(customer.getUserEmail().equals(p.getCustomerInfo().getUserEmail())) {
				payment = p;
				break;
			}
		}
		
		
		return cid.updateCustomerEmail(customer, email) &
				pid.updatePaymentEmail(payment, customer);
	}
	
	//update payment
	public Boolean updatePayment(PaymentInfo payment,
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
		
		return pid.updatePaymentCardNumber(payment, cardNumber) 
				& pid.updatePaymentSecurityCode(payment, securityCode)
				& pid.updatePaymentExpirationDate(payment, expirationDate) 
				& pid.updatePaymentBillingAddress(payment, billingAddress, billingCity,
						billingState, billingZip);
	}
	
	//update points
	public Boolean updatePoints(CustomerInfo customer, Ticket ticket, 
										Boolean smallDiscount, Boolean bigDiscount) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		UserType userType = customer.getRole();
		Double price = Math.floor(ticket.getTicketPrice());
		int points = customer.getAccumulatedPoints();
		if (smallDiscount) {
			points = customer.getAccumulatedPoints()-5000;
		} else if (bigDiscount) {
			points = customer.getAccumulatedPoints()-10000;
		} else {
			if (userType.getRoleId() == 1) {
				points = customer.getAccumulatedPoints()+(int)(price*10);
			} else if (userType.getRoleId() == 2) {
				points = customer.getAccumulatedPoints()+(int)(price*25);
			}
			
		}
		return cid.updateCustomerAccumulatedPoints(customer, points);
	}
	
	//update role
	public boolean updateRole(CustomerInfo customer, Integer roleId) {
		UserTypeDao utd = new UserTypeDaoImpl();
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		List<UserType> roles = utd.getUserTypes();
		UserType userType = null;
		
		for(UserType role: roles) {
			if (role.getRoleId() == roleId) {
				userType = role;
				break;
			}
		}
		
		
		return cid.updateCustomerUserType(customer, userType);
	}
	
	//update address
	public boolean updateAddress(CustomerInfo customer,
										String address,
										String city,
										String state,
										Integer zip) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		return cid.updateCustomerAddress(customer, address, city, state, zip);
	}
	
	//update password
	public boolean updatePassword(CustomerInfo customer, String password) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		return cid.updateCustomerPassword(customer, password);
	}
	
	//update display name
	public boolean updateDisplayName(CustomerInfo customer, String displayName) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		return cid.updateCustomerDisplayName(customer, displayName);
	}
	
	//update name
	public boolean updateCustomerName(CustomerInfo customer, String fName, String lName) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		cid.updateCustomerFName(customer, fName);
		return cid.updateCustomerLName(customer, lName);
	}
	
	//update post
	public boolean updatePost(Post post, String postContent) {
		PostDao pd = new PostDaoImpl();
		
		return pd.updatePost(post, postContent);
	}
	
	//update ticket price
	public boolean updateTicketPrice(Ticket ticket, Double price) {
		TicketDao td = new TicketDaoImpl();
		
		ticket.setTicketPrice(price);
		
		return td.updateTicket(ticket);
	}
	
	//update post title
	public boolean updatePostTitle(PostTitle postTitle, String newTitle) {
		PostTitleDao ptd = new PostTitleDaoImpl();
		
		return ptd.updatePostTitle(postTitle, newTitle);
	}
}
