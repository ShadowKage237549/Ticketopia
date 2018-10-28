import { Post } from './comment/ForumComment';
import { Component, OnInit } from '@angular/core';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { Topic } from '../forumtopic/topic/topic';
import { ForumcommentsService } from '../../Services/ForumComments/forumcomments.service';
import { PostTitle } from 'src/app/Components/forumpost/post/ForumPost';
import { post } from 'selenium-webdriver/http';
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
    constructor(private fcs: ForumcommentsService) { }
    postTitle: PostTitle;
    posts: Post[];


    ngOnInit() {
        (async () => {
            await delay(500);
            this.postTitle = this.fcs.postTitle;
            console.log(this.postTitle);
            this.fcs.getPostsByTitleId(this.postTitle.id);
            await delay(500);
            this.posts = this.fcs.posts;
            console.log(this.posts);
        })();
    }
}
