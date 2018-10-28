package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.EventType;

public interface EventTypeDao {
	
	//Create new eventType
	public boolean createEventType(EventType eventType);
	//Update an existing EventType
	public boolean updateEventType(EventType eventType);
	//Return a list of eventTypes
	public List<EventType> getAllEventTypes();
	//Remove an event type
	public boolean removeEventType(EventType eventType);
	
}
