package com.ticketopia.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Post;
import com.ticketopia.beans.Ticket;
import com.ticketopia.util.HibernateUtil;

public class PostDaoImpl implements PostDao {
	@Override
	public boolean createPost(Post post) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(post);
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
	public List<Post> getPosts() {
		Session session = null;
		List<Post> posts = new ArrayList<>();
		
		try {
			session = HibernateUtil.getSession();
			posts = (List<Post>)session.createQuery("FROM Post").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return posts;
	}
}
