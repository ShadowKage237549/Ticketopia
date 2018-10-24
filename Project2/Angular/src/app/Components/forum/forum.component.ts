
import { Topic } from './../forumtopic/topic/topic';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TopicService } from '../../Services/Forumtopic/topic.service';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  constructor(private topicService:TopicService) { }
  //Each topic is an anchor which leads to the forumtopic.component
  
  topics:Topic[] = this.topicService.topics;
  selectForumtopic(topic:Topic){
    this.topicService.selectedTopic = topic;
  }

  ngOnInit() {
  }

}

