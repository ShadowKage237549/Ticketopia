package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.Post;
import com.ticketopia.beans.Ticket;
import com.ticketopia.beans.Topic;
import com.ticketopia.util.HibernateUtil;

public class TopicDaoImpl implements TopicDao{
	private final static Logger logger = Logger.getLogger(TopicDaoImpl.class);

	// gets all topics
	@Override
	public List<Topic> getAllTopics() {
		logger.info("getAllTopics called");
		Session session = null;
		List<Topic> topics = null;
		
		try {			
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			topics = (List<Topic>)session.createQuery("FROM Topic").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("returning topics");
		return topics;
	}
	
	// gets a topic by it's id
	@Override
	public Topic getTopicById(Integer id) {
		logger.info("getTopicById called");
		Session session = null;
		Topic topic = null;
		
		try {
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			topic = (Topic)session.get(Topic.class, id);
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		logger.info("returing topic");
		return topic;
	}

	// adds a topic
	@Override
	public boolean addTopic(Topic topic) {
		logger.info("addTopic called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("about to hit db");
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
		logger.info("returning false");
		return false;
	}
	
	// removes a topic from db
	@Override
	public boolean removeTopic(Topic topic) {
		logger.info("removeTopic called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.delete(topic);
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
	
	// updates a topic
	@Override
	public boolean updateTopic(Topic topic) {
		logger.info("updateTopic called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			logger.info("getting topic object");
			Topic t = (Topic) session.get(Topic.class, topic.getId());
			t = topic;
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
