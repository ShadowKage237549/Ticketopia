package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="posts_title")
public class PostTitle {
	@Id
	@Column(name="post_title_id")
	@SequenceGenerator(sequenceName="title_id_sqn", name="title_Id")
	@GeneratedValue(generator="title_Id", strategy=GenerationType.SEQUENCE)
	private Integer Id;
	
	@Column(name="topic_id")
	private Integer topicId;
	
	@Column(name="post_title")
	private String postTitle;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public PostTitle(Integer id, Integer topicId, String postTitle) {
		super();
		Id = id;
		this.topicId = topicId;
		this.postTitle = postTitle;
	}

	public PostTitle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PostTitle [Id=" + Id + ", topicId=" + topicId + ", postTitle=" + postTitle + "]";
	}


}
