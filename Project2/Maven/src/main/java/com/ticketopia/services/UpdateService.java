package com.ticketopia.services;

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
		Integer newPoints = accumulatedPoints - points;
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
	public Boolean updatePayment(CustomerInfo customer, Long cardNumber, 
							Integer securityCode, String expirationDate, String billingAddress, 
							String billingCity, String billingState, Integer billingZip) {
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
		
		return pid.updatePaymentInfo(payment, customer);
	}
	
	//update post
	public boolean updatePost(Integer postId, PostTitle postTitle, String postContent,
			CustomerInfo displayName, String postTimeStamp) {
		PostDao pd = new PostDaoImpl();
		Post post = new Post();
		
		post.setPostId(postId);
		post.setPostTitle(postTitle);
		post.setPostContent(postContent);
		post.setDisplayName(displayName);
		post.setPostTimeStamp(postTimeStamp);
		
		return pd.updatePost(post);
	}
	
	public boolean updateTopic(Integer id, Ticket ticketId, String topicName, String topicDescription) {
		TopicDao td = new TopicDaoImpl();
		Topic topic = new Topic();
		
		topic.setId(id);
		topic.setTicketId(ticketId);
		topic.setTopicName(topicName);
		topic.setTopicDescription(topicDescription);
		
		return td.updateTopic(topic);
	}
	
	public boolean updateTicket(Integer ticketId, String ticketType, EventType eventType, Double ticketPrice,
			String eventDescription, String eventAddress, String eventCity, String eventState,
			Integer eventZip, String seat, Partner partner, boolean free) {
		TicketDao td = new TicketDaoImpl();
		Ticket ticket = new Ticket();
		
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
		
		return td.updateTicket(ticket);
	}
	
	//update post title
	public boolean updatePostTitle(Integer id, Topic topic, String newTitle) {
		PostTitleDao ptd = new PostTitleDaoImpl();
		PostTitle postTitle = new PostTitle();
		
		postTitle.setId(id);
		postTitle.setPostTitle(newTitle);
		postTitle.setTopicId(topic);
		
		return ptd.updatePostTitle(postTitle);
	}
}
