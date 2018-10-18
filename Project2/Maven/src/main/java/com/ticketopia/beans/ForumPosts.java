package com.ticketopia.beans;

public class ForumPosts {
	private Integer postId;
	private String postTitle;
	private String postContent;
	private Integer topicId;
	private Integer displayName;
	private String postTimeStamp;
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public Integer getDisplayName() {
		return displayName;
	}
	public void setDisplayName(Integer displayName) {
		this.displayName = displayName;
	}
	public String getPostTimeStamp() {
		return postTimeStamp;
	}
	public void setPostTimeStamp(String postTimeStamp) {
		this.postTimeStamp = postTimeStamp;
	}
	@Override
	public String toString() {
		return "ForumPosts [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", topicId=" + topicId + ", displayName=" + displayName + ", postTimeStamp=" + postTimeStamp + "]";
	}
	public ForumPosts(Integer postId, String postTitle, String postContent, Integer topicId, Integer displayName,
			String postTimeStamp) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.topicId = topicId;
		this.displayName = displayName;
		this.postTimeStamp = postTimeStamp;
	}
	public ForumPosts(String postTitle, String postContent, Integer topicId, Integer displayName,
			String postTimeStamp) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.topicId = topicId;
		this.displayName = displayName;
		this.postTimeStamp = postTimeStamp;
	}
	public ForumPosts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
