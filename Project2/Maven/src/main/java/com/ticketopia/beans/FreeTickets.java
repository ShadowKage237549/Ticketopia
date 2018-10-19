package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FreeTickets")
public class FreeTickets {
	@Column(name="ticketId")
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
