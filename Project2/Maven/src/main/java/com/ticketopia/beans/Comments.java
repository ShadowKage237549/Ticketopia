package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity //Marks the class as a persistent class
@Table(name="Comments")
public class Comments {
	@Id //Marks as a primary key
	@Column(name="comment_id")
	@SequenceGenerator(sequenceName="MY_SEQ", name="Comments_seq")
	@GeneratedValue(generator="Comments_seq", strategy=GenerationType.SEQUENCE)
	private Integer commentId;
	
	@Column(name="post_id")
	private Integer postId;
	
	@Column(name="display_name")
	private String displayName;
	
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
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
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
		return "Comments [commentId=" + commentId + ", postId=" + postId + ", displayName=" + displayName + ", commentContent="
				+ commentContent + ", commentTimeStamp=" + commentTimeStamp + "]";
	}
	public Comments(Integer commentId, Integer postId, String displayName, String commentContent, String commentTimeStamp) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.displayName = displayName;
		this.commentContent = commentContent;
		this.commentTimeStamp = commentTimeStamp;
	}
	public Comments(Integer postId, String displayName, String commentContent, String commentTimeStamp) {
		super();
		this.postId = postId;
		this.displayName = displayName;
		this.commentContent = commentContent;
		this.commentTimeStamp = commentTimeStamp;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
