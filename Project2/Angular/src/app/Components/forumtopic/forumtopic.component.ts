import { ActivatedRoute, Router } from '@angular/router';
import { PostTitle } from './../forumpost/post/ForumPost';
import { Topic } from './topic/topic';
import { Component, OnInit } from '@angular/core';
import { TopicService } from '../../Services/Forumtopic/topic.service';

@Component({
    selector: 'app-forumtopic',
    templateUrl: './forumtopic.component.html',
    styleUrls: ['./../forum/forum.component.css']
})
export class ForumtopicComponent implements OnInit {
    // //ForumtopicComponent is the page which displays all posts within a given forum topic.
    // //Each post links to ForumpostComponent
    // topicId: number = Number.parseInt(this.activatedRoute.snapshot.url[1].path);
    // //topic: Topic = this.getTopicById(this.topicId);
    // //posts:ForumPost = this.postService.getPosts();
    // postTitle: string = "Post title";
    // posts: ForumPost[] = [
    //     new ForumPost(1, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(2, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(3, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(4, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(5, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(6, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(7, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(8, "Post Title x", "Post Description of Post Title x"),
    //     new ForumPost(9, "Post Title x", "Post Description of Post Title x")];
    // postDescription: String = "the first 100 characters of the post content";
    // postContent: string;

    // constructor(private activatedRoute: ActivatedRoute, private topicService: TopicService) { }

    ngOnInit() {
        // if (Number.parseInt(this.activatedRoute.snapshot.url[1].path)) {
        //     this.topicId = Number.parseInt(this.activatedRoute.snapshot.url[1].path);
        //     console.log(1);
        // }
        // else if (Number.parseInt(this.activatedRoute.snapshot.url[2].path)) {
        //     this.topicId = Number.parseInt(this.activatedRoute.snapshot.url[2].path);
        //     console.log(2);
        // }
        //this.topic = this.getTopicById(this.topicId);
    }

    // getTopicById(id: number) {
    //     if (this.topicService.selectedTopic != null) {
    //         if (id == this.topicService.selectedTopic.topicId) {
    //             this.topic = this.topicService.selectedTopic;
    //         }
    //     } else
    //         if (this.topicService.selectedTopic == null) {
    //             this.topic = this.topicService.getTopicById(id);
    //         }
    //     return this.topic;
    // }





}
