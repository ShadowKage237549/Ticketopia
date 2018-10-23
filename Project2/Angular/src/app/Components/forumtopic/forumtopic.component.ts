import { ActivatedRoute, Router } from '@angular/router';
import { ForumPost } from './../forumpost/post/ForumPost';
import { Topic } from './topic/topic';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-forumtopic',
  templateUrl: './forumtopic.component.html',
  styleUrls: ['./forumtopic.component.css']
})
export class ForumtopicComponent implements OnInit {
  //ForumtopicComponent is the page which displays all posts within a given forum topic.
  //Each post links to ForumpostComponent

  selectedTopic: Topic = new Topic(1, "topic 1", "topic 1 description of the topic");
  topicCategory: string = this.selectedTopic.topicName;
  topicId: number = this.selectedTopic.topicId;
  postTitle: string = "Post title";
  posts: ForumPost[] = [
    new ForumPost(1, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(2, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(3, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(4, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(5, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(6, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(7, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(8, "Post Title x", "Post Description of Post Title x"),
    new ForumPost(9, "Post Title x", "Post Description of Post Title x")];
  postDescription: String = "the first 100 characters of the post content";
  postContent: string;

  constructor(private activatedRoute:ActivatedRoute, private router:Router) { }

  ngOnInit() {
    console.log(this.activatedRoute.snapshot.url[2].path);
  }



 

}
