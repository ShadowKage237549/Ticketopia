package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.Comments;
import com.ticketopia.beans.ForumPosts;

public interface ForumCommentDao {
	// create new comment
			// takes in topic and post
			// sends these along with comment and timestamp to database
				// also user who made the comment
		
		// get comments
			// is sent a topic and a post
			// returns a list of comments under those categories
	
	public List <Comments> getPostComments(ForumPosts post);
	
	public boolean NewComment(
			
			int postId,
			String displayName,
			String timeStamp,
			String commentContent
			);
	
}
