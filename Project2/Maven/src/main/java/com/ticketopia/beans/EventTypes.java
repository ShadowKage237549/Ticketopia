package com.ticketopia.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity //Marks the class as a persistent class
@Table(name="event_types")
public class EventTypes {
	@Id
	@Column(name="event_type_id")
	@SequenceGenerator(sequenceName="Event_Seq", name="EventTypes_seq")
	@GeneratedValue(generator="EventTypes_seq", strategy=GenerationType.SEQUENCE)
	private Integer eventTypeId;
	
	@Column(name="event_type")
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
	public EventTypes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
