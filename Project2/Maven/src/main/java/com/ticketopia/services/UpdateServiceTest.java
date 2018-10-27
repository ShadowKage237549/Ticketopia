package com.ticketopia.services;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.PaymentInfo;
import com.ticketopia.beans.Post;
import com.ticketopia.beans.PostTitle;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.UserType;
import com.ticketopia.daos.CustomerInfoDaoImpl;
import com.ticketopia.daos.PaymentInfoDaoImpl;
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
	public static PaymentInfo payment = new PaymentInfo(customer2, 1000555577777888L, 000, "01/99", 
			"111 Killer Rd", "Heart Broken Town", "Mn", 543876);
	private static PaymentInfo paymentInfo = mock(PaymentInfo.class);
	private static Post post = mock(Post.class);
	private static Ticket ticket = mock(Ticket.class);
	private static PostTitle postTitle = mock(PostTitle.class);
	
	public static UpdateService us = new UpdateService();
	public static CustomerInfoDaoImpl cid = mock(CustomerInfoDaoImpl.class);
	private static PaymentInfoDaoImpl pid = mock(PaymentInfoDaoImpl.class);
	private static PostDao pd = new PostDaoImpl();
	private static TicketDao td = new TicketDaoImpl();
	private static PostTitleDao ptd = new PostTitleDaoImpl();
	
	private static UserType role1 = new UserType(1, "basic");
	private static String email = "customer@info.com";
	private static List<PaymentInfo> payments = new ArrayList<>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		payments.add(paymentInfo);
		
		when(cid.updateCustomerInfo(customer, email)).thenReturn(true);
		when(pid.updatePaymentInfo(paymentInfo, customer)).thenReturn(true);
		Mockito.doReturn(payments).when(pid).getPayments();
//		when(pd.updatePost(post)).thenReturn(true);
//		when(td.updateTicket(ticket)).thenReturn(true);
//		when(ptd.updatePostTitle(postTitle)).thenReturn(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTicketPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePostTitle() {
		fail("Not yet implemented");
	}

}
