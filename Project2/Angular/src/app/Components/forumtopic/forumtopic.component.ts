import { ActivatedRoute } from '@angular/router';
import { PostTitle } from './../forumpost/post/ForumPost';
import { Topic } from './topic/topic';
import { Component, OnInit, SimpleChanges, OnChanges } from '@angular/core';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { ForumcommentsService } from '../../Services/ForumComments/forumcomments.service';
import { ForumpostService } from '../../Services/ForumPost/forumpost.service';
import { Post } from '../forumpost/comment/ForumComment';
import { async } from '@angular/core/testing';
async function delay(ms: number) {
    return new Promise(resourse => setTimeout(resourse, ms));
}
@Component({
    selector: 'app-forumtopic',
    templateUrl: './forumtopic.component.html',
    styleUrls: ['./../forum/forum.component.css']
})
export class ForumtopicComponent implements OnInit, OnChanges {
    // //ForumtopicComponent is the page which displays all posts within a given forum topic.

    // tslint:disable-next-line:max-line-length
    constructor(private topicService: TopicService, private fps: ForumpostService, private fcs: ForumcommentsService, private ar: ActivatedRoute) { }
    topicId: number = null;
    topic: Topic = null;
    newPost: Post = {
        postId: 0,
        postTitle: {
            id: 0,
            postTitle: '',
            topicId: 0,
        },
        postContent: '',
        customer: '',
    };
    postTitles: PostTitle[] = null;
    newPostTitle: PostTitle = {
        id: 0,
        postTitle: '',
        topicId: 0
    };
    ngOnChanges(changes: SimpleChanges): void {
        if (this.postTitles != null) {
            this.postTitles = this.fps.postTitles;
        }
        if (this.topic != null) {
            this.topic = this.topicService.selectedTopic;
        }
    }

    ngOnInit() {
        (async () => {
            this.topic = this.topicService.selectedTopic;
            if (this.topic != null) {
                this.topicId = this.topic.id;
            } else {
                if (this.ar.snapshot.url[3]) {
                    this.topicId = Number.parseInt(this.ar.snapshot.url[3].path, 10);
                } else {
                    this.topicId = Number.parseInt(this.ar.snapshot.url[2].path, 10);
                }

                this.topicService.getTopicById(this.topicId);
                setInterval(async () => { this.topic = this.topicService.selectedTopic; }, 400);
            }
            if (this.postTitles == null) {
                this.fps.getPostsById(this.topicId);
                setInterval(async () => { this.postTitles = this.fps.postTitles; }, 400);
            }
        })();
    }

    storePostTitle(postTitle: PostTitle) {
        this.fcs.postTitle = postTitle;
    }

    createPostTitle() {
        (async () => {
            this.newPostTitle.topicId = this.topicId;
            this.fps.addPostTitle(this.newPostTitle);
            await delay(1000);
            this.newPost.postTitle = this.newPostTitle;
            this.newPost.postTitle.id = this.fps.postTitleId;
            this.fcs.createPost(this.newPost);
        })();

    }

    loggedIn() {
        if (localStorage.getItem("token")) {
            return true;
        }
        return false;
    }

}
