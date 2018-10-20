package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.EventTypes;
import com.ticketopia.beans.Tickets;

public interface TicketDao {
	// get all tickets
			// simply retrieve all tickets and associated info
	public List<Tickets> getAllTickets();
		
		// get tickets by event type
			// retrieve tickets sorted by event type
	public List<Tickets> getTicketByEvent(EventTypes event);
		
		// get tickets by location
			// should be passed in a list of tickets along with a location
				// ie all or by event type
			// return a list filtered by location
	public List<Tickets> getTicketByLocation(String address, String city, String state, Integer zip);
		
		// get tickets by price
			// should be passed in a list of tickets along with a max price
			// return a list of tickets below that price
	public List<Tickets> getTicketByPrice(Integer lowPrice, Integer highPrice);
	public List<Tickets> getTicketByPrice(Integer lowPrice);
		
		// get tickets by type
			// should be passed in a list of tickets as well as a type
			// return a list of tickets of that type
		
		// add tickets
			// allows admin to create new tickets
			// this method might move to a different class
		
		// get free tickets
			// returns the tickets whose id is in the free table
		
		// get tickets by seat
			// should be passed in a list of tickets and a seat
			// finds the seat and returns that ticket
}
