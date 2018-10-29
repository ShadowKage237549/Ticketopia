package com.ticketopia.services;

import static org.testng.Assert.assertTrue;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.Post;
import com.ticketopia.beans.PostTitle;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.Topic;
import com.ticketopia.beans.UserType;
import com.ticketopia.daos.PostDao;
import com.ticketopia.daos.PostDaoImpl;
import com.ticketopia.daos.PostTitleDao;
import com.ticketopia.daos.PostTitleDaoImpl;
import com.ticketopia.daos.TicketDao;
import com.ticketopia.daos.TicketDaoImpl;

public class UpdateServiceTest {
	public static CustomerInfo customer = new CustomerInfo("jjohnson@aol.com", "Kakashi", "Jordan", "Johnson", 
				6000, 1, "1857 Chidori Cir", "Wyoming", "Kentucky", 107410, "ILikeTurtles");
	public static CustomerInfo customer2 = new CustomerInfo("bob.bobson@mafia.net", "Mafia Master",
				"Bob", "Bobson", 98765432, 2, "100 Killer Rd", "Heart Broken Town", "MN", 999969, "password");
	public static CustomerInfo customer3 = new CustomerInfo("destiny.a@gmail.com", "TheDestiny", "Destiny",
				"Adams", 7500, 2, "2342 Destined Rd", "Mankato", "Kentucky", 666656, "Starbucks");	
	public static PaymentInfo payment = new PaymentInfo(customer2, 1000555577777888L, 000, "01/99", 
			"111 Killer Rd", "Heart Broken Town", "Mn", 543876);
	private static EventType eventType = new EventType(1, "Movie");
	private static Partner partner = new Partner(2, "regression films ltd", 
			"regression films aims to sell discounted tickets by directly working with movie producers.");
	private static Ticket ticket = new Ticket(7, "Movie Ticket", eventType, 99.00, 
			"Back Row seating for Venom with beer, popcorn, and ices included", "777 Zmax Blvd",
			"Reston", "Virginia", 869434, "Z-1", partner, false);
	private static Topic topic = new Topic(1, ticket, "Venom the Movie!", 
			"Ticket admitting entrance to the movie Venom");
	public static PostTitle postTitle = new PostTitle(1, 1, "DID YOU SEE HOW VENOM TRANSFORMED?!!!@#");
	public static Post post = new Post(1, postTitle, 
			"Venom was amazing! The way he transformed... his style, he is my FAVORITE VILLAIN!!! AHHH",
			customer3, Timestamp.valueOf(LocalDateTime.now()));

	
	public static UpdateService us = new UpdateService();
	private static PostDao pd = new PostDaoImpl();
	private static TicketDao td = new TicketDaoImpl();
	private static PostTitleDao ptd = new PostTitleDaoImpl();
	
	private static UserType role1 = new UserType(1, "basic");
	private static String email = "customer@info.com";
	private static List<PaymentInfo> payments = new ArrayList<>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void testUpdateCustomer() {
		assertTrue(us.updateCustomer("jjohnson@aol.com", "jjohnson@aol.com", "Kakashi", "Jordan", "Johnson", 
				6000, 1, "1857 Chidori Cir", "Wyoming", "Kentucky", 107410, "ILikeTurtles", 20.55, true, false));
	}

	@Test
	public void testUpdatePayment() {
		assertTrue(us.updatePayment(customer2, 1000555577777888L, 000, "01/99", 
			"111 Killer Rd", "Heart Broken Town", "Mn", 543876));
	}

	@Test
	public void testUpdatePost() {
		assertTrue(us.updatePost(1, postTitle, 
				"Venom was gross",
				customer3, Timestamp.valueOf(LocalDateTime.now())));
	}

	@Test
	public void testUpdateTicket() {
		assertTrue(us.updateTicket(7, "Movie Ticket", eventType, 99.00, "Venom Movie", "777 Zmax Blvd",
				"Reston", "Virginia", 869434, "Z-1", partner, false));
	}
	
	@Test
	public void testUpdateTopic() {
		assertTrue(us.updateTopic(1, ticket, "Venom the Movie!", 
				"Talk about the Venom movie"));
	}

	@Test
	public void testUpdatePostTitle() {
		assertTrue(us.updatePostTitle(1, topic, "Venom was OK"));
	}

}
