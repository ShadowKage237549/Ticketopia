package com.ticketopia.daos;

import java.util.List;

import com.ticketopia.beans.Topic;

public interface TopicDao {
	public List<Topic> getAllTopics();

	public boolean addTopic(Topic T);
	public boolean removeTopic(Topic topic);
	public boolean updateTopic(Topic topic);
}
