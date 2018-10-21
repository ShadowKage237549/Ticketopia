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

@Entity //Marks the class as a persistent class
@Table(name="Comments")
public class Comment {
	@Id //Marks as a primary key
	@Column(name="comment_id")
	@SequenceGenerator(sequenceName="Comment_Generator", name="Comment_Id")
	@GeneratedValue(generator="Comment_Seq", strategy=GenerationType.SEQUENCE)
	private Integer commentId;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="display_name")
	private CustomerInfo displayName;
	
	@Column(name="comment_content")
	private String commentContent;
	
	@Column(name="comment_time_stamp")
	private String commentTimeStamp;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public CustomerInfo getDisplayName() {
		return displayName;
	}

	public void setDisplayName(CustomerInfo displayName) {
		this.displayName = displayName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentTimeStamp() {
		return commentTimeStamp;
	}

	public void setCommentTimeStamp(String commentTimeStamp) {
		this.commentTimeStamp = commentTimeStamp;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", post=" + post + ", displayName=" + displayName
				+ ", commentContent=" + commentContent + ", commentTimeStamp=" + commentTimeStamp + "]";
	}

	public Comment(Integer commentId, Post post, CustomerInfo displayName, String commentContent,
			String commentTimeStamp) {
		super();
		this.commentId = commentId;
		this.post = post;
		this.displayName = displayName;
		this.commentContent = commentContent;
		this.commentTimeStamp = commentTimeStamp;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
