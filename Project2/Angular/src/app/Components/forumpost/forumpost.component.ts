import { ForumPost } from './post/ForumPost';
import { ForumComment } from './comment/ForumComment';
import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-forumpost',
    templateUrl: './forumpost.component.html',
    styleUrls: ['./forumpost.component.css']
})
export class ForumpostComponent implements OnInit {

    constructor() { }
    //ForumpostComponent is the page which displays the comments within a given forum post.
    selectedPost: ForumPost = new ForumPost(1, "Post Title 1", "Post Content");
    forumComments: ForumComment[] = [new ForumComment(2, "commentContent")];
    postId: number = this.selectedPost.postId;
    postContent: string = this.selectedPost.postContent;
    postTitle: string = this.selectedPost.postTitle;

    ngOnInit() {

    }
}
