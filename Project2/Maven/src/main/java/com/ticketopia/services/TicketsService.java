package com.ticketopia.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.Ticket;

public class TicketsService {
	private final static Logger logger = Logger.getLogger(TicketsService.class);
	// get ticket by price
	public static List<Ticket> getTicketByPrice(List<Ticket> tickets, Double maxPrice) {
		logger.info("getTicketByPrice called");
		List<Ticket> pTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getTicketPrice() <= maxPrice) {
				pTickets.add(ticket);
				logger.info("adding ticket to list");
			}
		}
		logger.info("returning list of tickets");
		return pTickets;
	}
	
	// get ticket by the city the event is in
	public static List<Ticket> getTicketByLocation(List<Ticket> tickets, String city) {
		logger.info("getTicketByLocation");
		List<Ticket> lTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getEventCity().equals(city)) {
				lTickets.add(ticket);
				logger.info("adding ticket to list");
			}
		}
		logger.info("returning list of tickets");
		return lTickets;
	}
	
	// get ticket by event type
	public static List<Ticket> getTicketByEventType(List<Ticket> tickets, EventType event) {
		logger.info("getTicketByEventType called");
		List<Ticket> eTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getEventType().equals(event)) {
				eTickets.add(ticket);
				logger.info("adding ticket to list");
			}
		}
		logger.info("returning list of tickets");
		return eTickets;
	}
	
	// get ticket by partner
	public static List<Ticket> getTicketByPartner(List<Ticket> tickets, Partner partner) {
		logger.info("getTicketByPartner called");
		List<Ticket> pTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getPartner().equals(partner)) {
				pTickets.add(ticket);
				logger.info("adding ticket to list");
			}
		}
		logger.info("returning list of tickets");
		return pTickets;
	}
}
