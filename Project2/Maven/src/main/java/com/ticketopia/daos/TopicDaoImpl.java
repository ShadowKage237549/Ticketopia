package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.Topic;
import com.ticketopia.util.HibernateUtil;

public class TopicDaoImpl implements TopicDao{

	@Override
	public List<Topic> getAllTopics() {
		Session session = null;
		List<Topic> topics = null;
		
		try {			
			session = HibernateUtil.getSession();
			topics = (List<Topic>)session.createQuery("FROM Topic").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return topics;
	}

	@Override
	public boolean addTopic(Topic topic) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(topic);
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
