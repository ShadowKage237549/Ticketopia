package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.Topics;

public interface ForumTopicDao {
	// get all topics
			// returns a list of all topics
	public List<Topics> getAllTopics();
}
