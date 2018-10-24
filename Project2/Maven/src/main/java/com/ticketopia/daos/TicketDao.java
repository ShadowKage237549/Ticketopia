package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.Topic;

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
	
	public Boolean updateTicket(Ticket ticket);
}
