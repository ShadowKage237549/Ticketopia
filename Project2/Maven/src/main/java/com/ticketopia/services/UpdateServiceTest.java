package com.ticketopia.services;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;

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

public class UpdateServiceTest {
	public static CustomerInfo customer = mock(CustomerInfo.class);
	private static PaymentInfo paymentInfo = mock(PaymentInfo.class);
	private static Post post = mock(Post.class);
	private static Ticket ticket = mock(Ticket.class);
	private static PostTitle postTitle = mock(PostTitle.class);
	public static UpdateService us = new UpdateService();
	public static CustomerInfoDao cid = mock(CustomerInfoDaoImpl.class);
	private static PaymentInfoDao pid = new PaymentInfoDaoImpl();
	private static PostDao pd = new PostDaoImpl();
	private static TicketDao td = new TicketDaoImpl();
	private static PostTitleDao ptd = new PostTitleDaoImpl();
	private static UserType role1 = new UserType(1, "basic");
	private static CustomerInfo customer1 = new CustomerInfo("original@email.org", "Slappey", 
			"Ben", "Bobbert", 100, role1, "12345 Street Ln", "City", "state", 00000, "admin");
	
	private static String email = "customer@info.com";;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		when(cid.updateCustomerInfo(customer,email)).thenReturn(true);
//		when(pid.updatePaymentInfo(paymentInfo)).thenReturn(true);
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
	public void testUpdateEmail() {
		assertTrue(us.updateEmail(customer, email));
	}

	@Test
	public void testUpdatePayment() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRole() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDisplayName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCustomerName() {
		fail("Not yet implemented");
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
