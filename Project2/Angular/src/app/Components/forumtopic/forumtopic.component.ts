import { ActivatedRoute } from '@angular/router';
import { PostTitle } from './../forumpost/post/ForumPost';
import { Topic } from './topic/topic';
import { Component, OnInit } from '@angular/core';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { ForumcommentsService } from '../../Services/ForumComments/forumcomments.service';
import { ForumpostService } from '../../Services/ForumPost/forumpost.service';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-forumtopic',
    templateUrl: './forumtopic.component.html',
    styleUrls: ['./../forum/forum.component.css']
})
export class ForumtopicComponent implements OnInit {
    // //ForumtopicComponent is the page which displays all posts within a given forum topic.

    // tslint:disable-next-line:max-line-length
    constructor(private topicService: TopicService, private fps: ForumpostService, private fcs: ForumcommentsService, private ar: ActivatedRoute) { }
    topicId: number = null;
    topic: Topic = null;

    postTitles: PostTitle[] = null;
    ngOnInit() {
        (async () => {
            this.topic = this.topicService.selectedTopic;
            if (this.topic != null) {
                this.topicId = this.topic.id;
            } else {
                if (Number.parseInt(this.ar.snapshot.url[3].path) != null) {
                    this.topicId = Number.parseInt(this.ar.snapshot.url[3].path, 10);
                } else {
                    this.topicId = Number.parseInt(this.ar.snapshot.url[2].path, 10);
                }

                this.topicService.getTopicById(this.topicId);
                await delay(500);
                this.topic = this.topicService.selectedTopic;
            }
            if (this.postTitles == null) {
                this.fps.getPostsById(this.topicId);
                await delay(500);
                this.postTitles = this.fps.postTitles;
            }
        })();
    }

    storePostTitle(postTitle: PostTitle) {
        this.fcs.postTitle = postTitle;
    }



}
