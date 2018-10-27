package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Ticket;

public interface TicketDao {
	// get all tickets
			// simply retrieve all tickets and associated info
	public List<Ticket> getAllTickets();
	
	// add tickets
		// allows admin to create new tickets
		// this method might move to a different class
	public Integer addTicket(Ticket ticket);
		
	
	// buy tickets
		// remove this ticket id from the database
	public Boolean removeTicket(Ticket ticket);
	
	public Boolean updateTicketType(Ticket ticket, String type);
	public Boolean updateTicketEventType(Ticket ticket, EventType eventType);
	public Boolean updateTicketPrice(Ticket ticket, Double price);
	public Boolean updateTicketDescription(Ticket ticket, String description);
	public Boolean updateTicketAddress(Ticket ticket, String address,
			String city, String state, Integer zip);
	public Boolean updateTicketSeat(Ticket ticket, String seat);
	public Boolean updateTicketFreeStatus(Ticket ticket, Boolean flag);

}

