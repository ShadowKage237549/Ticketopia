package com.ticketopia.beans;

public class FreeTickets {
	private Integer ticketId;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	@Override
	public String toString() {
		return "FreeTickets [ticketId=" + ticketId + "]";
	}

	public FreeTickets(Integer ticketId) {
		super();
		this.ticketId = ticketId;
	}

	public FreeTickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
