import { Post } from './comment/ForumComment';
import { Component, OnInit, SimpleChanges, OnChanges } from '@angular/core';
import { Topic } from '../forumtopic/topic/topic';
import { ForumcommentsService } from '../../Services/ForumComments/forumcomments.service';
import { PostTitle } from 'src/app/Components/forumpost/post/ForumPost';
import { ActivatedRoute } from '@angular/router';
import { ForumpostService } from '../../Services/ForumPost/forumpost.service';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-forumpost',
    templateUrl: './forumpost.component.html',
    styleUrls: ['./forumpost.component.css']
})
export class ForumpostComponent implements OnInit, OnChanges {
    constructor(private fcs: ForumcommentsService, private ar: ActivatedRoute, private fps: ForumpostService) { }
    postTitle: PostTitle = null;
    postTitleId: number;
    posts: Post[];
    post: Post = {
        postId: 0,
        postTitle: {
            id: 0,
            postTitle: '',
            topicId: 0,
        },
        postContent: '',
        customer: '',
    };
    ngOnChanges(changes: SimpleChanges): void {
        if (this.posts != null) {
            this.posts = this.fcs.posts;
        }
        if (this.postTitle != null) {
            this.postTitle = this.fps.postTitles[0];
        }
    }

    ngOnInit() {
        (() => {
            this.postTitle = this.fcs.postTitle;
            if (this.postTitle != null) {
                this.postTitleId = this.postTitle.id;
            } else {
                this.postTitleId = Number.parseInt(this.ar.snapshot.url[3].path, 10);
            }
            this.fcs.getPostsByTitleId(this.postTitleId);
            setInterval((async () => { this.posts = this.fcs.posts; }), 500);
        })();
    }

    loggedIn() {
        if (localStorage.getItem("token")) {
            return true;
        }
        return false;
    }

    createPost() {
        this.post.customer = localStorage.getItem("email");
        this.post.postTitle = this.posts[0].postTitle;
        this.fcs.createPost(this.post);
    }
}
