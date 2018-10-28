package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.annotations.Pos;

import com.ticketopia.beans.PostTitle;
import com.ticketopia.util.HibernateUtil;

public class PostTitleDaoImpl implements PostTitleDao {
	@Override
	public boolean createPostTitle(PostTitle postTitle) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			session.save(postTitle);
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
	public List<PostTitle> getPostTitles() {
		Session session = null;
		List<PostTitle> postTitles = null;
		
		try {
			session = HibernateUtil.getSession();
			postTitles = (List<PostTitle>)session.createQuery("FROM PostTitle").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return postTitles;
	}
	
	@Override
	public boolean updatePostTitle(PostTitle postTitle) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PostTitle pt = (PostTitle) session.get(PostTitle.class, postTitle.getId());
			pt = postTitle;
			session.merge(pt);
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
	public List<PostTitle> getPostTitlesById(Integer id) {
		Session session = null;
		String hql = "FROM PostTitle where topic_id = :id";
		Query query = null;
		List<PostTitle> postTitles = null;
		try {
			session = HibernateUtil.getSession();
			query = session.createQuery(hql);
			query.setParameter("id", id);
			postTitles = query.list();
		}catch(HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return postTitles;
	}
}
