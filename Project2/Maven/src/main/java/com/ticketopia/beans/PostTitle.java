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
@Table(name="post_title")
public class PostTitle {
	@Id
	@SequenceGenerator(sequenceName="title_id_sqn", name="title_Id")
	@GeneratedValue(generator="title_Id", strategy=GenerationType.SEQUENCE)
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	private Integer postId;
	
	@Column(name="post_title")
	private String postTitle;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

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

	@Override
	public String toString() {
		return "PostTitle [Id=" + Id + ", postId=" + postId + ", postTitle=" + postTitle + "]";
	}

	public PostTitle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostTitle(Integer id, Integer postId, String postTitle) {
		super();
		Id = id;
		this.postId = postId;
		this.postTitle = postTitle;
	}
	
	
}
