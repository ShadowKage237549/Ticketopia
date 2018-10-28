package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Post;
import com.ticketopia.util.HibernateUtil;

public class PostDaoImpl implements PostDao {
	private final static Logger logger = Logger.getLogger(PostDaoImpl.class);
	
	// creates a new post
	@Override
	public boolean createPost(Post post) {
		logger.info("createPost called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("about to hit the db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(post);
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
	
	// gets all posts
	@Override
	public List<Post> getPosts() {
		logger.info("getPosts called");
		Session session = null;
		List<Post> posts = null;
		
		try {
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			posts = (List<Post>)session.createQuery("FROM Post").list();
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("returning posts");
		return posts;
	}
	
	// updates a post object
	@Override
	public boolean updatePost(Post post) {
		logger.info("updatePost called");
		Session session = null;
		Transaction tx = null;
		
		try {
			logger.info("about to hit db");
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Post p = (Post) session.get(Post.class, post.getPostId());
			p = post;
			session.merge(p);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			logger.warn("Something went wrong");
			e.printStackTrace();
		} finally {
			session.close();
		}
		logger.info("returning false");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPostsByTitleId(Integer id) {
		List<Post> posts = null;
		Session session = null;
		Query query = null;
		String hql = "FROM Post WHERE post_title_id = :id";
		try {
			session = HibernateUtil.getSession();
			query = session.createQuery(hql);
			query.setParameter("id", id);
			posts = query.list();
			System.out.println(posts);
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return posts;
	}
}
