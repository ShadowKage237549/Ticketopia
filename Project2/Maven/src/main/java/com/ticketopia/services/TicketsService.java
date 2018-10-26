package com.ticketopia.services;

import java.util.ArrayList;
import java.util.List;

import com.ticketopia.beans.Ticket;

public class TicketsService {
	// get ticket by price
	public List<Ticket> getTicketByPrice(List<Ticket> tickets, Double maxPrice) {
		List<Ticket> pTickets = new ArrayList<>();
		for(Ticket ticket: tickets) {
			if(ticket.getTicketPrice() <= maxPrice) {
				pTickets.add(ticket);
			}
		}
		return pTickets;
	}
	// get ticket by location
	// get ticket by event type
	// get ticket by partner
	//
}
