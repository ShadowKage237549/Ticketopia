package com.ticketopia.daos;

import com.ticketopia.beans.EventType;

public interface EventTypesDao {
	
	//Create new eventType
	public boolean createEventType(EventType eventType);
	//Update an existing EventType
	public boolean UpdateEventType(EventType eventType);
	//Return an array of eventTypes
	public EventType[] selectAllEventTypes();
	//Return a single EventType by its ID
	public EventType selectEventTypeById(Integer id);
	
}
