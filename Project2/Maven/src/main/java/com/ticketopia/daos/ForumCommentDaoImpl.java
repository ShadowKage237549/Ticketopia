package com.ticketopia.daos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.hql.internal.ast.tree.Statement;

import com.ticketopia.beans.Comment;
import com.ticketopia.beans.Comments;
import com.ticketopia.beans.ForumPosts;
import com.ticketopia.util.HibernateUtil;

public class ForumCommentDaoImpl implements ForumCommentDao {
/*
 * This will handle the implemenation for the ForumCommentDao.
 */
	
	private final static Logger logger = Logger.getLogger(Comments.class);
	
	public List<Comment> getPostComments(){
		
		Statement stmt = null;
		ResultSet rs = null;
		List<Comment> comments = new ArrayList<>();
		
		Comment com = null;
		Session session = HibernateUtil.getSession();
		return comments;
		
	}

	@Override
	public List<Comment> getPostComments(ForumPost post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean NewComment(int postId, String displayName, String timeStamp, String commentContent) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
