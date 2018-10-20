package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topics {
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
	public Topics(Integer topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}
	public Topics(String topicName) {
		super();
		this.topicName = topicName;
	}
	public Topics() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
