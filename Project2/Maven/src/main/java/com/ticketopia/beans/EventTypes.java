package com.ticketopia.beans;

public class EventTypes {
	private Integer eventTypeId;
	private String eventType;
	public Integer getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(Integer eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	@Override
	public String toString() {
		return "EventTypes [eventTypeId=" + eventTypeId + ", eventType=" + eventType + "]";
	}
	public EventTypes(Integer eventTypeId, String eventType) {
		super();
		this.eventTypeId = eventTypeId;
		this.eventType = eventType;
	}
	public EventTypes(String eventType) {
		super();
		this.eventType = eventType;
	}
	public EventTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
