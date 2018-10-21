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
		
		// get tickets by event type
			// retrieve tickets sorted by event type
	public List<Ticket> getTicketByEvent(EventType event);
		
		// get tickets by location
			// should be passed in a list of tickets along with a location
				// ie all or by event type
			// return a list filtered by location
	public List<Ticket> getTicketByLocation(String address, String city, String state, Integer zip);
		
		// get tickets by price
			// should be passed in a list of tickets along with a max price
			// return a list of tickets below that price
	public List<Ticket> getTicketByPrice(Integer lowPrice, Integer highPrice);
	public List<Ticket> getTicketByPrice(Integer price);
		
		// add tickets
			// allows admin to create new tickets
			// this method might move to a different class
	public boolean addTicket(String ticketType,
							Topic topic,
							EventType eventType,
							Double ticketPrice,
							String eventDescription,
							String eventAddress,
							String eventCity,
							String eventState,
							Integer eventZip,
							String seat,
							Partner partner,
							Character freeList);
		
		// get free tickets
			// returns the tickets whose id is in the free table
	public List<Ticket> getFreeTickets(); // KEEP THIS
	
	// buy tickets
				// remove this ticket id from the database
	public Boolean buyTickets(Ticket ticket);
			
			// apply discount
				// takes in number of points
				// removes ticket from database
				// modifies the price then charges user
				// removes points from user account
	public Boolean buyDiscountTicket(Ticket ticket, CustomerInfo customer, Integer discountChoice);
			
			// get free ticket
				// gets passed a ticket
				// removes it from database without charging user
	
}
