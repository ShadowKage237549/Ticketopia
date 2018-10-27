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
	public boolean updateCustomer(String oldEmail, String newEmail, String displayName, String userFName,
			String userLName, Integer accumulatedPoints, Integer role, String userAddress, String userCity,
			String userState, Integer userZip, String password, Double price, boolean lessPoints,
			boolean morePoints) {
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		CustomerInfo customer = new CustomerInfo();
		
		customer.setUserEmail(oldEmail);
		customer.setDisplayName(displayName);
		customer.setUserFName(userFName);
		customer.setUserLName(userLName);
		if (lessPoints) {
			customer.setAccumulatedPoints(subtractPoints(5000, accumulatedPoints));
		} else if (morePoints) {
			customer.setAccumulatedPoints(subtractPoints(10000, accumulatedPoints));
		} else {
			customer.setAccumulatedPoints(addPoints(role, price, accumulatedPoints));
		}
		customer.setRole(role);
		customer.setUserAddress(userAddress);
		customer.setUserCity(userCity);
		customer.setUserState(userState);
		customer.setUserZip(userZip);
		customer.setPassword(password);
		return cid.updateCustomerInfo(customer, newEmail);
	}
	
	public Integer subtractPoints(Integer points, Integer accumulatedPoints) {
		Integer newPoints = accumulatedPoints = points;
		return newPoints;
	}
	
	public Integer addPoints(Integer role, Double price, Integer accumulatedPoints) {
		Integer points = accumulatedPoints;
		if (role == 1) {
			points = accumulatedPoints+(int)(price*10);
		} else if (role == 2) {
			points = accumulatedPoints+(int)(price*25);
		}
		return points;
	}
	
	//update payment
	public Boolean updatePayment(CustomerInfo customer, Long cardNumber, Integer securityCode, 
							String expirationDate, String billingAddress, String billingCity,
							String billingState, Integer billingZip) {
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		PaymentInfo payment = new PaymentInfo();
		
		payment.setCustomerInfo(customer);
		payment.setCardNumber(cardNumber);
		payment.setSecurityCode(securityCode);
		payment.setExpirationDate(expirationDate);
		payment.setBillingAddress(billingAddress);
		payment.setBillingCity(billingCity);
		payment.setBillingState(billingState);
		payment.setBillingZip(billingZip);
		
		return pid.updatePaymentInfo(payment);
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
