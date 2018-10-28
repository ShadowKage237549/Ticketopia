import { Post } from './comment/ForumComment';
import { Component, OnInit } from '@angular/core';
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
export class ForumpostComponent implements OnInit {
    topics: Topic[];
    constructor(private fcs: ForumcommentsService, private ar: ActivatedRoute, private fps: ForumpostService) { }
    postTitle: PostTitle = null;
    postTitleId: number;
    posts: Post[];


    ngOnInit() {
        (async () => {
            await delay(500);
            this.postTitle = this.fcs.postTitle;
            if (this.postTitle != null) {
                this.postTitleId = this.postTitle.id;
            } else {
                this.postTitleId = Number.parseInt(this.ar.snapshot.url[3].path, 10);
                this.fps.getPostsById(Number.parseInt(this.ar.snapshot.url[2].path, 10));
                await delay(500);
                this.postTitle = this.fps.postTitles[0];
            }
            this.fcs.getPostsByTitleId(this.postTitleId);
            await delay(500);
            this.posts = this.fcs.posts;
        })();
    }
}
