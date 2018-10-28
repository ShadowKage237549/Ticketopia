package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.EventType;
import com.ticketopia.beans.Ticket;
import com.ticketopia.util.HibernateUtil;

public class TicketDaoImpl implements TicketDao {
	private final static Logger logger = Logger.getLogger(TicketDaoImpl.class);
	@SuppressWarnings("unchecked")

	// gets all tickets
	@Override
	public List<Ticket> getAllTickets() {
		logger.info("getAllTickets called");
		Session session = null;
		List<Ticket> tickets = null;
		
		try {			
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			tickets = (List<Ticket>)session.createQuery("FROM Ticket").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("returning tickets");
		return tickets;
	}
	
	// adds a ticket to db
	@Override
	public Integer addTicket(Ticket ticket) {
		logger.info("addTicket called");
		Session session = null;
		Transaction tx = null;
		Integer id = null;
		
		try {
			logger.info("about to hit db");
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
		logger.info("returning ticket id");
		return id;
	}
	
	// removes a ticket from db
	@Override
	public Boolean removeTicket(Ticket ticket) {
		logger.info("removeTicket called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("getting ticket object");
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
		logger.info("returning false");
		return false;
	}
	
	// updates ticket object
	@Override
	public boolean updateTicket(Ticket ticket) {
		logger.info("updateTicket called");
		Session session = null;
		Transaction tx = null;
		
		try { 
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("getting ticket object");
			Ticket t = (Ticket) session.get(Ticket.class, ticket.getTicketId());
			t = ticket;
			session.merge(t);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		logger.info("returning false");
		return false;
	}
}