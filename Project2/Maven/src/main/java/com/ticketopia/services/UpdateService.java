package com.ticketopia.services;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.EventType;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.Post;
import com.ticketopia.beans.PostTitle;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.UserType;
import com.ticketopia.daos.CustomerInfoDao;
import com.ticketopia.daos.CustomerInfoDaoImpl;
import com.ticketopia.daos.EventTypeDao;
import com.ticketopia.daos.EventTypeDaoImpl;
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
	public static CustomerInfoDaoImpl cid;
	public static PaymentInfoDaoImpl pid;
	
	public boolean updateCustomer(String oldEmail, String newEmail, String displayName, String userFName,
			String userLName, Integer accumulatedPoints, Integer role, String userAddress, String userCity,
			String userState, Integer userZip, String password, Double price, boolean lessPoints,
			boolean morePoints) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		return false;
	}
	
	//update email
	public Boolean updateEmail(CustomerInfo customer, String email) {
		//cid = new CustomerInfoDaoImpl();
		//PaymentInfoDao pid = new PaymentInfoDaoImpl();
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
		customer.setAccumulatedPoints(points);
		return cid.updateCustomerInfo(customer);
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
		
		customer.setRole(userType);
		return cid.updateCustomerInfo(customer);
	}
	
	//update address
	public boolean updateAddress(CustomerInfo customer,
										String address,
										String city,
										String state,
										Integer zip) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		customer.setUserAddress(address);
		customer.setUserCity(city);
		customer.setUserState(state);
		customer.setUserZip(zip);
		return cid.updateCustomerInfo(customer);
	}
	
	//update password
	public boolean updatePassword(CustomerInfo customer, String password) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		customer.setPassword(password);
		
		return cid.updateCustomerInfo(customer);
	}
	
	//update display name
	public boolean updateDisplayName(CustomerInfo customer, String displayName) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		customer.setDisplayName(displayName);
		
		return cid.updateCustomerInfo(customer);
	}
	
	//update name
	public boolean updateCustomerName(CustomerInfo customer, String fName, String lName) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		
		customer.setUserFName(fName);
		customer.setUserLName(lName);
		
		return cid.updateCustomerInfo(customer);
	}
	
	//update post
	public boolean updatePost(Post post, String postContent) {
		PostDao pd = new PostDaoImpl();
		
		return pd.updatePost(post, postContent);
	}
	
	//update ticket price
	public boolean updateTicketPrice(Ticket ticket, Double price) {
		TicketDao td = new TicketDaoImpl();
		
		return td.updateTicketPrice(ticket, price);
	}
	
	public boolean updateTicketType(Ticket ticket, String price) {
		TicketDao td = new TicketDaoImpl();
		
		return td.updateTicketType(ticket, price);
	}
	
	public boolean updateTicketEventType(Ticket ticket, Integer eventId) {
		TicketDao td = new TicketDaoImpl();
		EventTypeDao etd = new EventTypeDaoImpl();
		List<EventType> events = etd.getAllEventTypes();
		EventType eventType = null;
		
		for(EventType event: events) {
			if (event.getEventTypeId() == eventId) {
				eventType = event;
				break;
			}
		}
		
		return td.updateTicketEventType(ticket, eventType);
	}
	
	public boolean updateTicketDescription(Ticket ticket, String description) {
		TicketDao td = new TicketDaoImpl();
		
		return td.updateTicketType(ticket, description);
	}
	
	public boolean updateTicketAddress(Ticket ticket, String address,
										String city, String state, Integer zip) {
		TicketDao td = new TicketDaoImpl();
		
		return td.updateTicketAddress(ticket, address, city, state, zip);
	}
	
	public boolean updateTicketSeat(Ticket ticket, String seat) {
		TicketDao td = new TicketDaoImpl();
		
		return td.updateTicketType(ticket, seat);
	}
	
	public boolean updateTicketFreeStatus(Ticket ticket, Boolean flag) {
		TicketDao td = new TicketDaoImpl();
		
		return td.updateTicketFreeStatus(ticket, flag);
	}
	
	//update post title
	public boolean updatePostTitle(PostTitle postTitle, String newTitle) {
		PostTitleDao ptd = new PostTitleDaoImpl();
		
		return ptd.updatePostTitle(postTitle, newTitle);
	}
}
