package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.EventType;
import com.ticketopia.util.HibernateUtil;

public class EventTypeDaoImpl implements EventTypeDao {
	@Override
	public boolean createEventType(EventType eventType) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(eventType);
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
	public boolean UpdateEventType(EventType eventType) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.update(eventType);
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
	public List<EventType> getAllEventTypes() {
		Session session = null;
		List<EventType> eventTypes = null;
		
		try {			
			session = HibernateUtil.getSession();
			eventTypes = (List<EventType>)session.createQuery("FROM EventType").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return eventTypes;
	}
	
	@Override
	public boolean removeEventType(EventType eventType) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(eventType);
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
