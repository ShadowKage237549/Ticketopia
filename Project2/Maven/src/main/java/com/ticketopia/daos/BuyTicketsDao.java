package com.ticketopia.daos;

public interface BuyTicketsDao {
	// buy tickets
			// remove this ticket id from the database
		
		// apply points
			// should take in the price of the ticket
			// apply points to users account
		
		// apply discount
			// takes in number of points
			// removes ticket from database
			// modifies the price then charges user
			// removes points from user account
				// this might get moved to a different method
		
		// get free ticket
			// gets passed a ticket
			// removes it from database without charging user
}
