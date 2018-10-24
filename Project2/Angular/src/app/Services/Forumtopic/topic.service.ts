import { Topic } from './../../Components/forumtopic/topic/topic';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TopicService {
  topics: Topic[] = this.getTopics(true);
  selectedTopic: Topic;
  constructor() { }
  getTopicById(id: number) {

    //Check if the topics are available.
    if (this.topics == null) {
      //If the topics are not available, get the topics
      this.topics = this.getTopics(true);
      //if the topics are still null, the request failed.
      if (this.topics == null) {
        return null;
      }
    }

    //Check if the topics array contains the required ticket
    if (this.topics[id] == null) {
      //if it does not, request the topics again.
      this.topics = this.requestTopics();
    }
    //If the ticket is still null, then just return null.
    if (this.topics[id-1] != null) {
      return this.topics[id-1];
    }
    return null;
  }


  //request pertains to whether you want to send a HTTP GET request.
  getTopics(request:boolean) {
    //TODO update tickets with the correct HTTP GET
    //return the updated ticket array
    if(request){
      return this.requestTopics();
    } else{
      return this.topics;
    }
  }

  //HTTP://18.222.219.232:8085/Ticketopia/{Whatever it does .do}
  requestTopics() {
    //TODO make http.get

    return [    
      new Topic(1, "topic 1", "topic 1 description of the topic"),
      new Topic(2, "topic 2", "topic 2 description of the topic")];
  }
}
