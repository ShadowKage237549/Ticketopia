package com.ticketopia.daos;

import com.ticketopia.beans.Comment;
import com.ticketopia.beans.Post;

public interface CommentDao {
	// create new comment
			// takes in topic and post
			// sends these along with comment and timestamp to database
				// also user who made the comment
		public boolean createNewComment(Comment comment);
		// get comments
			// is sent a topic and a post
			// returns a list of comments under those categories
		public boolean getAllCommentsByPost(Post post);
		
		//Delete the comment by the ID
		public boolean RemoveCommentById(Integer id);
		
		//Update Comment
		public boolean updateComment(Comment comment);
}
