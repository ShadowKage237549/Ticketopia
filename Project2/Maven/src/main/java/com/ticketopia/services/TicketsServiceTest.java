package com.ticketopia.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.Ticket;
import com.ticketopia.daos.TicketDao;
import com.ticketopia.daos.TicketDaoImpl;

public class TicketsServiceTest {
	private static TicketDao td = new TicketDaoImpl();
	private static Ticket ticket = mock(Ticket.class);
	private static Ticket ticket1 = new Ticket(1, "backstage", new EventType(1, "concert"),
			99.99, "Amon Amarth", "1234 Concert Ln", "Concert City", "Concert State", 67890,
			"pit", new Partner(1, "Napalm Records"), false);
	private static Ticket ticket2 = new Ticket(2, "realD", new EventType(2, "movie"), 20.00,
			"Venom Movie", "5678 Movie Str", "Movie City", "Movie State", 12345, "A1",
			new Partner(2, "AMC"), false);
	private static Ticket ticket3 = new Ticket(3, "basic", new EventType(1, "concert"), 19.95,
			"Unleash the Archers", "1234 Concert Ln", "Concert City", "Concert State", 67890,
			"pit", new Partner(1, "Napalm Records"), true);
	private static List<Ticket> tickets = new ArrayList<>();
	private static List<Ticket> testTickets = new ArrayList<>();
	private static String city;
	private static EventType eventType = null;
	private static Partner partner = null;
	private static Double maxPrice;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//when(td.addTicket(ticket)).thenReturn(1);
		tickets.add(ticket1);
		tickets.add(ticket2);
		tickets.add(ticket3);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		testTickets.clear();
	}

	@Test
	public void testGetTicketByPrice() {
		testTickets.add(ticket2);
		testTickets.add(ticket3);
		maxPrice = 50.00;
		assertEquals(TicketsService.getTicketByPrice(tickets, maxPrice), testTickets);
	}
	
	@Test
	public void testGetTicketByPrice3() {
		testTickets.add(ticket1);
		testTickets.add(ticket2);
		testTickets.add(ticket3);
		maxPrice = 100.00;
		assertEquals(TicketsService.getTicketByPrice(tickets, maxPrice), testTickets);
	}
	
	@Test
	public void testGetTicketByPrice2() {
		testTickets.add(ticket3);
		maxPrice = 19.99;
		assertEquals(TicketsService.getTicketByPrice(tickets, maxPrice), testTickets);
	}

	@Test
	public void testGetTicketByLocation() {
		testTickets.add(ticket1);
		testTickets.add(ticket3);
		city = "Concert City";
		assertEquals(TicketsService.getTicketByLocation(tickets, city), testTickets);
	}
	
	@Test
	public void testGetTicketByLocation2() {
		testTickets.add(ticket2);
		city = "Movie City";
		assertEquals(TicketsService.getTicketByLocation(tickets, city), testTickets);
	}

	@Test
	public void testGetTicketByEventType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTicketByPartner() {
		fail("Not yet implemented");
	}

}
