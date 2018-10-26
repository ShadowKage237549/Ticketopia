package com.ticketopia.services;

import static org.junit.Assert.*;


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

public class TicketsServiceTest {
	private static EventType eventType1 = new EventType(1, "concert");
	private static EventType eventType2 = new EventType(2, "movie");
	private static EventType eventType3 = new EventType(3, "festival");
	private static Partner partner1 = new Partner(1, "Napalm Blast");
	private static Partner partner2 = new Partner(2, "AMC");
	private static Partner partner3 = new Partner(3, "Nuclear Records");
	private static Ticket ticket1 = new Ticket(1, "backstage", eventType1,
			99.99, "Amon Amarth", "1234 Concert Ln", "Concert City", "Concert State", 67890,
			"pit", partner1, false);
	private static Ticket ticket2 = new Ticket(2, "realD", eventType2, 20.00,
			"Venom Movie", "5678 Movie Str", "Movie City", "Movie State", 12345, "A1",
			partner2, false);
	private static Ticket ticket3 = new Ticket(3, "basic", eventType1, 19.95,
			"Unleash the Archers", "1234 Concert Ln", "Concert City", "Concert State", 67890,
			"pit", partner1, true);
	private static List<Ticket> tickets = new ArrayList<>();
	private static List<Ticket> testTickets = new ArrayList<>();
	private static String city;
	
	
	private static Double maxPrice;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testGetTicketByPrice2() {
		testTickets.add(ticket1);
		testTickets.add(ticket2);
		testTickets.add(ticket3);
		maxPrice = 100.00;
		assertEquals(TicketsService.getTicketByPrice(tickets, maxPrice), testTickets);
	}
	
	@Test
	public void testGetTicketByPrice3() {
		testTickets.add(ticket3);
		maxPrice = 19.99;
		assertEquals(TicketsService.getTicketByPrice(tickets, maxPrice), testTickets);
	}
	
	@Test
	public void testGetTicketByPrice4() {
		maxPrice = 15.00;
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
	public void testGetTicketByLocation3() {
		city = "Movie";
		assertEquals(TicketsService.getTicketByLocation(tickets, city), testTickets);
	}

	@Test
	public void testGetTicketByEventType() {
		testTickets.add(ticket1);
		testTickets.add(ticket3);
		assertEquals(TicketsService.getTicketByEventType(tickets, eventType1), testTickets);
	}
	
	@Test
	public void testGetTicketByEventType2() {
		testTickets.add(ticket2);
		assertEquals(TicketsService.getTicketByEventType(tickets, eventType2), testTickets);
	}
	
	@Test
	public void testGetTicketByEventType3() {
		assertEquals(TicketsService.getTicketByEventType(tickets, eventType3), testTickets);
	}

	@Test
	public void testGetTicketByPartner() {
		testTickets.add(ticket1);
		testTickets.add(ticket3);
		assertEquals(TicketsService.getTicketByPartner(tickets, partner1), testTickets);
	}
	
	@Test
	public void testGetTicketByPartne2() {
		testTickets.add(ticket2);
		assertEquals(TicketsService.getTicketByPartner(tickets, partner2), testTickets);
	}
	
	@Test
	public void testGetTicketByPartner3() {
		assertEquals(TicketsService.getTicketByPartner(tickets, partner3), testTickets);
	}

}
