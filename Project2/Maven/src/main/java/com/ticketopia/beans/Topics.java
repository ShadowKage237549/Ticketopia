package com.ticketopia.beans;

public class Topics {
	private Integer topicId;
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
