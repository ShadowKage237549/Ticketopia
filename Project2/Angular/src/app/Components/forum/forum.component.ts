import { Topic } from './../forumtopic/topic/topic';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

  constructor(private hClient:HttpClient) { }
  //Each topic is an anchor which leads to the forumtopic.component
  
  topicCategories:Topic[] = [
    new Topic(1,"topic 1","topic 1 description of the topic"),
    new Topic(2,"topic 2","topic 2 description of the topic")
  ];

  ngOnInit() {
  }

}
