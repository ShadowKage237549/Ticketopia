import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forumtopic',
  templateUrl: './forumtopic.component.html',
  styleUrls: ['./forumtopic.component.css']
})
export class ForumtopicComponent implements OnInit {

  constructor() { }
  topic:string = "replace me with the forum topic that was clicked";
  topicId:number;
  postTitle:string = "Post title";
  postDescription:String = "the first 100 characters of the post content";
  postContent:string;
  

  ngOnInit() {
  }

}
