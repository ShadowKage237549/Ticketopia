package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.Topic;

public class TicketDaoImpl implements TicketDao {
	public List<Ticket> getAllTickets() {
		return null;
	}

	@Override
	public List<Ticket> getTicketByEvent(EventType event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketByLocation(String address, String city, String state, Integer zip) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketByPrice(Integer lowPrice, Integer highPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> getTicketByPrice(Integer price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTicket(String ticketType, Topic topic, EventType eventType, Double ticketPrice, String eventDescription, String eventAddress, String eventCity, String eventState,
			Integer eventZip, String seat, Partner partner, Character freeList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ticket> getFreeTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean buyTickets(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean buyDiscountTicket(Ticket ticket, CustomerInfo customer, Integer discountChoice) {
		// TODO Auto-generated method stub
		return null;
	}
}
