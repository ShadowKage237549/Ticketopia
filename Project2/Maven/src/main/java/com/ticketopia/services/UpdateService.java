package com.ticketopia.services;

import org.apache.log4j.Logger;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.Post;
import com.ticketopia.beans.PostTitle;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.Topic;
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
import com.ticketopia.daos.TopicDao;
import com.ticketopia.daos.TopicDaoImpl;

public class UpdateService {	
	private final static Logger logger = Logger.getLogger(UpdateService.class);
	
	// creates a new customer object to replace an old one with
	public boolean updateCustomer(String oldEmail, String newEmail, String displayName, String userFName,
			String userLName, Integer accumulatedPoints, Integer role, String userAddress, String userCity,
			String userState, Integer userZip, String password, Double price, boolean lessPoints,
			boolean morePoints) {
		logger.info("updateCustomer called");
		
		// creates objects
		CustomerInfoDao cid = new CustomerInfoDaoImpl();
		CustomerInfo customer = new CustomerInfo();
		
		// sets values of customer
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
		
		logger.info("sending new customer object to daoimpl");
		return cid.updateCustomerInfo(customer, newEmail);
	}
	
	// subtracts points from a user
	public Integer subtractPoints(Integer points, Integer accumulatedPoints) {
		logger.info("subtractPoints called");
		Integer newPoints = accumulatedPoints - points;
		return newPoints;
	}
	
	// adds points to a user, amount based on whether they're basic or premium
	public Integer addPoints(Integer role, Double price, Integer accumulatedPoints) {
		logger.info("addPoints called");
		Integer points = accumulatedPoints;
		if (role == 1) {
			points = accumulatedPoints+(int)(price*10);
		} else if (role == 2) {
			points = accumulatedPoints+(int)(price*25);
		}
		return points;
	}
	
	//creates payment object to update existing with
	public Boolean updatePayment(CustomerInfo customer, Long cardNumber, 
							Integer securityCode, String expirationDate, String billingAddress, 
							String billingCity, String billingState, Integer billingZip) {
		logger.info("updatePayment called");
		
		// creates objects
		PaymentInfoDao pid = new PaymentInfoDaoImpl();
		PaymentInfo payment = new PaymentInfo();
		
		// sets values of payment
		payment.setCustomerInfo(customer);
		payment.setCardNumber(cardNumber);
		payment.setSecurityCode(securityCode);
		payment.setExpirationDate(expirationDate);
		payment.setBillingAddress(billingAddress);
		payment.setBillingCity(billingCity);
		payment.setBillingState(billingState);
		payment.setBillingZip(billingZip);
		
		logger.info("sending object to daoimpl");
		return pid.updatePaymentInfo(payment, customer);
	}
	
	//creates post object to update existing with
	public boolean updatePost(Integer postId, PostTitle postTitle, String postContent,
			CustomerInfo displayName, String postTimeStamp) {
		logger.info("updatePost called");
		
		// creates objects
		PostDao pd = new PostDaoImpl();
		Post post = new Post();
		
		// sets values of post
		post.setPostId(postId);
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		post.setDisplayName(displayName);
		post.setPostTimeStamp(postTimeStamp);
		
		logger.info("sending object to daoimpl");
		return pd.updatePost(post);
	}
	
	//updates a topic
	public boolean updateTopic(Integer id, Ticket ticketId, String topicName, String topicDescription) {
		logger.info("updateTopic called");
		
		// creates objects
		TopicDao td = new TopicDaoImpl();
		Topic topic = new Topic();
		
		// sets values of topic
		topic.setId(id);
		topic.setTicketId(ticketId);
		topic.setTopicName(topicName);
		topic.setTopicDescription(topicDescription);
		
		logger.info("sending object to daoimpl");
		return td.updateTopic(topic);
	}
	
	//creates ticket object to update existing with
	public boolean updateTicket(Integer ticketId, String ticketType, EventType eventType, Double ticketPrice,
			String eventDescription, String eventAddress, String eventCity, String eventState,
			Integer eventZip, String seat, Partner partner, boolean free) {
		logger.info("updateTicket called");
		
		// creates objects
		TicketDao td = new TicketDaoImpl();
		Ticket ticket = new Ticket();
		
		// sets values of ticket
		ticket.setTicketId(ticketId);
		ticket.setTicketType(ticketType);
		ticket.setEventType(eventType);
		ticket.setTicketPrice(ticketPrice);
		ticket.setEventDescription(eventDescription);
		ticket.setEventAddress(eventAddress);
		ticket.setEventCity(eventCity);
		ticket.setEventState(eventState);
		ticket.setEventZip(eventZip);
		ticket.setSeat(seat);
		ticket.setPartner(partner);
		ticket.setFree(free);
		
		logger.info("sending object to daoimpl");
		return td.updateTicket(ticket);
	}
	
	//creates post title object to update existing with
	public boolean updatePostTitle(Integer id, Topic topic, String newTitle) {
		logger.info("updatePostTitle called");
		
		// creates objects
		PostTitleDao ptd = new PostTitleDaoImpl();
		PostTitle postTitle = new PostTitle();
		
		// sets values of postTitle
		postTitle.setId(id);
		postTitle.setPostTitle(newTitle);
		postTitle.setTopicId(topic);
		
		logger.info("sending object to daoimpl");
		return ptd.updatePostTitle(postTitle);
	}
}
