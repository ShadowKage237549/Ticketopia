package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Topic {
	@Id
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ticket_id")
	private Integer ticketId;
	
	@Column(name="topic_name")
	private String topicName;
	
	@Column(name="topic_desc")
	private String topicDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicDescription() {
		return topicDescription;
	}

	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", ticketId=" + ticketId + ", topicName=" + topicName + ", topicDescription=" + topicDescription + "]";
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
