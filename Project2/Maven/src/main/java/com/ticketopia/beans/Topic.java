package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topic {
	@Id
	@Column(name="topic_id")
	@SequenceGenerator(sequenceName="Topic_Generator", name="Topic_Id")
	@GeneratedValue(generator="Topic_Seq", strategy=GenerationType.SEQUENCE)
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
	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}