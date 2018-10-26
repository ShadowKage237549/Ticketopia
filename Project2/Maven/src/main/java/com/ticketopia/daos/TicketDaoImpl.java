package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Ticket;
import com.ticketopia.util.HibernateUtil;

public class TicketDaoImpl implements TicketDao {
	@SuppressWarnings("unchecked")

	@Override
	public List<Ticket> getAllTickets() {
		Session session = HibernateUtil.getSession();
		List<Ticket> tickets = null;
		
		try {			
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
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Integer id = null;
		
		try {
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
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(ticket);
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
	public Boolean updateTicket(Ticket ticket) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(ticket);
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