import { Injectable } from '@angular/core';
import { PostTitle } from 'src/app/Components/forumpost/post/ForumPost';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../Authentication/authentication.service';
import { Post } from '../../Components/forumpost/comment/ForumComment';

@Injectable({
    providedIn: 'root'
})
export class ForumcommentsService {
    postTitle: PostTitle;
    posts: Post[];
    constructor(private http: HttpClient, private auth: AuthenticationService) { }

    getPostsByTitleId(id: number) {
        this.http.get(this.auth.url + "posts.do?id=" + id).subscribe((data: Post[]) => this.posts = data);
    }
}
