package com.ticketopia.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ticketopia.beans.Comment;
import com.ticketopia.beans.Post;
import com.ticketopia.util.HibernateUtil;

public class CommentDaoImpl implements CommentDao {
/*
 * This will handle the implementation for the ForumCommentDao.
 */
	
	private final static Logger logger = Logger.getLogger(Comment.class);
	
	@Override
	public List<Comment> getPostComments(Post post){
		Session session = HibernateUtil.getSession();
		List<Comment> comments = null;
		Query query;
		
		try {
			String Hql = "FROM Comments WHERE post_id = :id"; //This is how we do HQL Phil
			query = session.createQuery(Hql);
			query.setParameter("id",post.getPostId());
			comments = query.list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return comments;
		
	}

	//Get the post linked to the comment
	@Override
	public Post getPost(Integer postId) {

		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Query query;
		String hql = null;
		Post post = null;
		
		
		try {
			hql = "FROM posts WHERE post_id = :postId";
			query = session.createQuery(hql);
			//look at the notes from ryan on how to get a resultset in hibernate
			//fill out then return the post object
			post = new Post();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			
		}
		return post;
	}

	@Override
	public boolean NewComment(int postId, String displayName, String timeStamp, String commentContent) {
		// TODO Auto-generated method stub
		return false;
	}

}