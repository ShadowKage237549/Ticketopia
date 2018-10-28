package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	public boolean updateTicket(Ticket ticket) {
		Session session = null;
		Transaction tx = null;
		
		try { 
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
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
		return false;
	}

	@Override
	public Ticket getTicketById(Integer id) {
		Ticket ticket = null;
		String hql = "FROM Ticket WHERE ticket_id = :id";
		Session session = null;
		Query query = null;
		try {
			session = HibernateUtil.getSession();
			query = session.createQuery(hql);
			query.setParameter("id", id);
			ticket = (Ticket) query.uniqueResult();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return ticket;
	}
}