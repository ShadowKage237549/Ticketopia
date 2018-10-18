package com.ticketopia.beans;

public class Comments {
	private Integer commentId;
	private Integer postId;
	private String displayName;
	private String message;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCommentTimeStamp() {
		return commentTimeStamp;
	}
	public void setCommentTimeStamp(String commentTimeStamp) {
		this.commentTimeStamp = commentTimeStamp;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", postId=" + postId + ", displayName=" + displayName + ", message="
				+ message + ", commentTimeStamp=" + commentTimeStamp + "]";
	}
	public Comments(Integer commentId, Integer postId, String displayName, String message, String commentTimeStamp) {
		super();
		this.commentId = commentId;
		this.postId = postId;
		this.displayName = displayName;
		this.message = message;
		this.commentTimeStamp = commentTimeStamp;
	}
	public Comments(Integer postId, String displayName, String message, String commentTimeStamp) {
		super();
		this.postId = postId;
		this.displayName = displayName;
		this.message = message;
		this.commentTimeStamp = commentTimeStamp;
	}
	public Comments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
