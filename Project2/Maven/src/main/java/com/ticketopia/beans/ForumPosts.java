package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Posts")
public class ForumPosts {
	@Id
	@Column(name="postId")
	@SequenceGenerator(sequenceName="Post_Seq", name="Post_Seq")
	@GeneratedValue(generator="Post_Seq", strategy=GenerationType.SEQUENCE)
	private Integer postId;
	
	@Column(name="postTitle")
	private String postTitle;
	
	@Column(name="postContent")
	private String postContent;
	
	@Column(name="topicId")
	private Integer topicId;
	
	@Column(name="displayName")
	private Integer displayName;
	
	@Column(name="post")
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
