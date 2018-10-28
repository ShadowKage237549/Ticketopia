package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.Post;

public interface PostDao {
	// create post
			// takes in topic
			// adds post to database
				// include user who made it and timestamp
	public boolean createPost(Post post);
		
		// get all posts
			// returns a list of all the posts
	public List<Post> getPosts();
	public boolean updatePost(Post post);
	public List<Post> getPostsByTitleId(Integer id);
}
