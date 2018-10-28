package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("returning topics");
		return topics;
	}
	
	@SuppressWarnings("unchecked")
	// gets a topic by it's id
	@Override
	public Topic getTopicById(Integer id) {
		logger.info("getTopicById called");
		Session session = null;
		Topic topic = null;
		Query query = null;
		String hql = "FROM Topic WHERE id = :id";
		try
		{
			session = HibernateUtil.getSession();
			query = session.createQuery(hql);
			query.setParameter("id", id);
			List<Topic> list = query.list();
			for(Topic t : list) {
				topic = t;
				break;
			}
		}catch(HibernateException e) {
			logger.warn("Something went wrong");
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
			logger.warn("Something went wrong");
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
			logger.warn("Something went wrong");
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
			logger.warn("Something went wrong");
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		logger.info("returning false");
		return false;
	}

}
