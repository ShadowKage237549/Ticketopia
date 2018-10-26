package com.ticketopia.services;

import java.util.ArrayList;
import java.util.List;

import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.Ticket;

public class TicketsService {
	// get ticket by price
	public static List<Ticket> getTicketByPrice(List<Ticket> tickets, Double maxPrice) {
		List<Ticket> pTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getTicketPrice() <= maxPrice) {
				pTickets.add(ticket);
			}
		}
		return pTickets;
	}
	
	// get ticket by location
	public static List<Ticket> getTicketByLocation(List<Ticket> tickets, String city) {
		List<Ticket> lTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getEventCity().equals(city)) {
				lTickets.add(ticket);
			}
		}
		return lTickets;
	}
	
	// get ticket by event type
	public static List<Ticket> getTicketByEventType(List<Ticket> tickets, EventType event) {
		List<Ticket> eTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getEventType().equals(event)) {
				eTickets.add(ticket);
			}
		}
		return eTickets;
	}
	
	// get ticket by partner
	public static List<Ticket> getTicketByPartner(List<Ticket> tickets, Partner partner) {
		List<Ticket> pTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getPartner().equals(partner)) {
				pTickets.add(ticket);
			}
		}
		return pTickets;
	}
}
