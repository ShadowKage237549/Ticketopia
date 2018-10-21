package com.ticketopia.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Partner;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.Topic;
import com.ticketopia.beans.UserType;
import com.ticketopia.util.HibernateUtil;

public class TicketDaoImpl implements TicketDao {
	@Override
	public List<Ticket> getAllTickets() {
		Session session = HibernateUtil.getSession();
		List<Ticket> tickets = null;
		
		try {			
			tickets = session.createQuery("FROM tickets").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tickets;
	}
	
	@Override
	public List<Ticket> getTicketByEvent(EventType event) {
		Session session = HibernateUtil.getSession();
		Query query;
		String hql;
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		try {			
			hql = "FROM EventType WHERE eventTypeId = :id";
			query = session.createQuery(hql);
			query.setParameter("id", event.getEventTypeId());
			tickets = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tickets;
	}
	
	@Override
	public List<Ticket> getTicketByLocation(String address, String city, String state, Integer zip) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		return tickets;
	}
	
	@Override
	public List<Ticket> getTicketByPrice(Integer lowPrice, Integer highPrice) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		return tickets;
	}
	
	@Override
	public List<Ticket> getTicketByPrice(Integer price) {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		return tickets;
	}
	
	@Override
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
			Character freeList) {
		return false;
	}
	
	@Override
	public List<Ticket> getFreeTickets() {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		return tickets;
	}
	
	@Override
	public Boolean buyTickets(Ticket ticket) {
		return false;
	}
}