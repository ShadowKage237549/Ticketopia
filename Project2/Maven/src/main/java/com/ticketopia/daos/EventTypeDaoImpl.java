package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.EventType;
import com.ticketopia.util.HibernateUtil;

public class EventTypeDaoImpl implements EventTypeDao {
	private final static Logger logger = Logger.getLogger(EventTypeDaoImpl.class);
	
	// Creates a new event type
	@Override
	public boolean createEventType(EventType eventType) {
		logger.info("createEventType called");
		
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit the database");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(eventType);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		logger.info("Returning false");
		return false;
	}
	
	// Updates an event type
	@Override
	public boolean updateEventType(EventType eventType) {
		logger.info("updateEventType called");
		Session session = null;
		Transaction tx = null;
		EventType et = null;
		
		try {
			logger.info("About to hit the db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			et = (EventType) session.get(EventType.class, eventType.getEventTypeId());
			et = eventType;
			session.merge(et);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		logger.info("Returning false");
		return false;
	}
	
	// Returns a list of all event types
	@Override
	public List<EventType> getAllEventTypes() {
		logger.info("getAllEventTypes called");
		Session session = null;
		List<EventType> eventTypes = null;
		
		try {			
			logger.info("About to hit the db");
			session = HibernateUtil.getSession();
			eventTypes = (List<EventType>)session.createQuery("FROM EventType").list();
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("Returning eventTypes");
		return eventTypes;
	}
	
	// Removes an event type
	@Override
	public boolean removeEventType(EventType eventType) {
		logger.info("removeEventType called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("About to hit the db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(eventType);
			tx.commit();
			return true;
		} catch(HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		logger.info("Returning false");
		return false;
	}
}
