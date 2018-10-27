package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.PostTitle;

public interface PostTitleDao {
	public boolean createPostTitle(PostTitle postTitle);
	public List<PostTitle> getPostTitles();
	public boolean updatePostTitle(PostTitle postTitle);
}
