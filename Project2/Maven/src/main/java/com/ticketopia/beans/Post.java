package com.ticketopia.beans;

import java.sql.Timestamp;

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
public class Post {
	@Id
	@Column(name="post_id")
	@SequenceGenerator(sequenceName="Post_Generator", name="Post_Id")
	@GeneratedValue(generator="Post_Id", strategy=GenerationType.SEQUENCE)
	private Integer postId;
	
	@ManyToOne
	@JoinColumn(name="post_title_id")
	private PostTitle postTitle;
	
	@Column(name="post_content")
	private String postContent;
	
	@ManyToOne
	@JoinColumn(name="customer_email")
	private CustomerInfo customer;
	
	@Column(name="post_timestamp")
	private Timestamp postTimeStamp;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public PostTitle getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(PostTitle postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getCustomer() {
		return customer.getDisplayName();
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public Timestamp getPostTimeStamp() {
		return postTimeStamp;
	}

	public void setPostTimeStamp(Timestamp postTimeStamp) {
		this.postTimeStamp = postTimeStamp;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", displayName=" + customer.getDisplayName() + ", postTimeStamp=" + postTimeStamp + "]";
	}

	public Post(Integer postId, PostTitle postTitle, String postContent, CustomerInfo customer, Timestamp postTimeStamp) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.customer = customer;
		this.postTimeStamp = postTimeStamp;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}



}
