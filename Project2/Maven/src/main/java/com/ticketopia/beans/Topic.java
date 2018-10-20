package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topic {
	@Id
	@Column(name="topic_id")
	private Integer topicId;
	
	@Column(name="topic_name")
	private String topicName;
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	@Override
	public String toString() {
		return "Topics [topicId=" + topicId + ", topicName=" + topicName + "]";
	}
	public Topic(Integer topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}
<<<<<<< HEAD:Project2/Maven/src/main/java/com/ticketopia/beans/Topic.java
	public Topic(String topicName) {
		super();
		this.topicName = topicName;
	}
	public Topic() {
=======
	public Topics() {
>>>>>>> b2582ba956cc61d72f80d104f0b8e7c172b0c92f:Project2/Maven/src/main/java/com/ticketopia/beans/Topics.java
		super();
		// TODO Auto-generated constructor stub
	}
	
}
