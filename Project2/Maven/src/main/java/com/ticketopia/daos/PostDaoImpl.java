package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Post;
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
		List<Post> posts = null;
		
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
	
	@Override
	public boolean updatePost(Post post) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Post p = (Post) session.get(Post.class, post.getPostId());
			p = post;
			session.merge(p);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
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
