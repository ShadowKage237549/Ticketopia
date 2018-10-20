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
public class EventType {
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
	public EventType(Integer eventTypeId, String eventType) {
		this.eventTypeId = eventTypeId;
		this.eventType = eventType;
	}
<<<<<<< HEAD:Project2/Maven/src/main/java/com/ticketopia/beans/EventType.java
	public EventType() {
=======
	public EventTypes() {
		super();
		// TODO Auto-generated constructor stub
>>>>>>> b2582ba956cc61d72f80d104f0b8e7c172b0c92f:Project2/Maven/src/main/java/com/ticketopia/beans/EventTypes.java
	}
	
}
