package com.ticketopia.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="free_tickets")
public class FreeTickets {
	@OneToOne
	@JoinColumn(name = "ticket_id")
	private Tickets ticket;

	public Tickets getTicket() {
		return ticket;
	}

	public void setTicket(Tickets ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "FreeTickets [ticket=" + ticket + "]";
	}

	public FreeTickets(Tickets ticket) {
		super();
		this.ticket = ticket;
	}

	public FreeTickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
