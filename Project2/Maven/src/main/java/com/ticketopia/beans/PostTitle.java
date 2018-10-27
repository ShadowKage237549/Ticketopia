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
@Table(name="posts_title")
public class PostTitle {
	@Id
	@Column(name="post_title_id")
	@SequenceGenerator(sequenceName="title_id_sqn", name="title_Id")
	@GeneratedValue(generator="title_Id", strategy=GenerationType.SEQUENCE)
	private Integer Id;
	
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topicId;
	
	@Column(name="post_title")
	private String postTitle;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Topic getTopicId() {
		return topicId;
	}

	public void setTopicId(Topic topicId) {
		this.topicId = topicId;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public PostTitle(Integer id, Topic topicId, String postTitle) {
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
