package com.ticketopia.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Post;
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
	public boolean updatePostTitle(PostTitle postTitle, String newTitle) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			PostTitle pt = (PostTitle) session.get(PostTitle.class, postTitle.getId());
			pt.setPostTitle(newTitle);
			session.update(pt);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
}
