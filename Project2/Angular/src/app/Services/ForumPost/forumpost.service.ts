import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../Authentication/authentication.service';
import { PostTitle } from 'src/app/Components/forumpost/post/ForumPost';
import { Post } from 'src/app/Components/forumpost/comment/ForumComment';
import { async } from '@angular/core/testing';

@Injectable({
    providedIn: 'root'
})
export class ForumpostService {
    postTitles: PostTitle[];
    postTitle: PostTitle;
    postTitleId: number;
    constructor(private http: HttpClient, private auth: AuthenticationService) { }

    getPostsById(id: number) {
        this.http.get(this.auth.url + 'postTitle.do?id=' + id).subscribe((data: PostTitle[]) => this.postTitles = data);
    }

    addPostTitle(title: PostTitle) {
        // tslint:disable-next-line:max-line-length
        this.http.get(this.auth.url + 'createPostTitle.do?title=' + title.postTitle + '&id=' + title.topicId).subscribe((data: number) => this.postTitleId = data);
        this.postTitle = title;
    }

}
