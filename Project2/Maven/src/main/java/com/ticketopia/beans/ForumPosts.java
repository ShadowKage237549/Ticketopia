package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class ForumPosts {
	@Id
	@Column(name="post_id")
	@SequenceGenerator(sequenceName="Post_Generator", name="Post_Id")
	@GeneratedValue(generator="Post_Seq", strategy=GenerationType.SEQUENCE)
	private Integer postId;
	
	@Column(name="post_title")
	private String postTitle;
	
	@Column(name="post_content")
	private String postContent;
	
	@ManyToOne // foreign key
	@JoinColumn(name = "topic_id")
	private Topics topic;
	
	@ManyToOne
	@JoinColumn(name="display_name")
	private CustomerInfo displayName;
	
	@Column(name="post_timestamp")
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

	public Topics getTopic() {
		return topic;
	}

	public void setTopic(Topics topic) {
		this.topic = topic;
	}

	public CustomerInfo getDisplayName() {
		return displayName;
	}

	public void setDisplayName(CustomerInfo displayName) {
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
		return "ForumPosts [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", topic="
				+ topic + ", displayName=" + displayName + ", postTimeStamp=" + postTimeStamp + "]";
	}

	public ForumPosts(Integer postId, String postTitle, String postContent, Topics topic, CustomerInfo displayName,
			String postTimeStamp) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.topic = topic;
		this.displayName = displayName;
		this.postTimeStamp = postTimeStamp;
	}

	public ForumPosts(String postTitle, String postContent, Topics topic, CustomerInfo displayName,
			String postTimeStamp) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.topic = topic;
		this.displayName = displayName;
		this.postTimeStamp = postTimeStamp;
	}

	public ForumPosts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
