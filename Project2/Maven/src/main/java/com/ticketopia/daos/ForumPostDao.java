package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.CustomerInfo;
import com.ticketopia.beans.ForumPost;
import com.ticketopia.beans.Topic;

public interface ForumPostDao {
	// create post
			// takes in topic
			// adds post to database
				// include user who made it and timestamp
	public boolean createPost(Topic topic, 
								CustomerInfo displayName,
								String postTitle,
								String postContent,
								String postTimeStamp);
		
		// get all posts
			// returns a list of all the posts
	public List<ForumPost> getPosts(Topic topic);
	
}
