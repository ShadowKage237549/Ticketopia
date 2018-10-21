package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.Comment;
import com.ticketopia.beans.Post;

public interface CommentDao {
	// create new comment
			// takes in topic and post
			// sends these along with comment and timestamp to database
				// also user who made the comment
		
		// get comments
			// is sent a topic and a post
			// returns a list of comments under those categories
	
	public List <Comment> getPost(Post post);
	
	public boolean NewComment(
			
			int postId,
			String displayName,
			String timeStamp,
			String commentContent
			);
	
}
