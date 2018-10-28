package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="topics")
public class Topic {
	@Id
	@Column(name="topic_id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="ticket_id")
	private Ticket ticketId;
	
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
		return ticketId.getTicketId();
	}

	public void setTicketId(Ticket ticketId) {
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
		return "Topic [id=" + id + ", ticketId=" + ticketId.getTicketId() + ", topicName=" + topicName + ", topicDescription=" + topicDescription + "]";
	}

	public Topic(Integer id, Ticket ticketId, String topicName, String topicDescription) {
		super();
		this.id = id;
		this.ticketId = ticketId;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
	}

	public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
