package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public Topic getTopicById(Integer id) {
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
			e.printStackTrace();
		}finally {
			session.close();
		}
		return topic;
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
	
	@Override
	public boolean removeTopic(Topic topic) {
		Session session = null;
		Transaction tx = null;
		
		try {
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
		return false;
	}
	
	@Override
	public boolean updateTopic(Topic topic) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
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
		return false;
	}

}
