package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Ticket;
import com.ticketopia.util.HibernateUtil;

public class TicketDaoImpl implements TicketDao {
	@SuppressWarnings("unchecked")

	@Override
	public List<Ticket> getAllTickets() {
		Session session = null;
		List<Ticket> tickets = null;
		
		try {			
			session = HibernateUtil.getSession();
			tickets = (List<Ticket>)session.createQuery("FROM Ticket").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tickets;
	}
	
	@Override
	public Integer addTicket(Ticket ticket) {
		Session session = null;
		Transaction tx = null;
		Integer id = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			id = (Integer)session.save(ticket);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return id;
	}
	
	@Override
	public Boolean removeTicket(Ticket ticket) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			session.delete(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Boolean updateTicketType(Ticket ticket, String type) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t.setTicketType(type);
			session.update(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Boolean updateTicketEventType(Ticket ticket, EventType eventType) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t.setEventType(eventType);
			session.update(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Boolean updateTicketPrice(Ticket ticket, Double price) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t.setTicketPrice(price);
			session.update(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Boolean updateTicketDescription(Ticket ticket, String description) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t.setEventDescription(description);
			session.update(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Boolean updateTicketAddress(Ticket ticket, String address,
											String city, String state, Integer zip) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t.setEventAddress(address);
			t.setEventCity(city);
			t.setEventState(state);
			t.setEventZip(zip);
			session.update(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Boolean updateTicketSeat(Ticket ticket, String seat) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t.setSeat(seat);
			session.update(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
	
	@Override
	public Boolean updateTicketFreeStatus(Ticket ticket, Boolean flag) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t.setFree(flag);
			session.update(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}
}