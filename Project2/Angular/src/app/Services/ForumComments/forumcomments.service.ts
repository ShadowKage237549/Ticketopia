import { Injectable } from '@angular/core';
import { PostTitle } from 'src/app/Components/forumpost/post/ForumPost';
import { HttpClient, HttpParams, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
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
        this.http.get(this.auth.url + 'posts.do?id=' + id).subscribe((data: Post[]) => this.posts = data);
    }



    createPost(post: Post) {
        console.log(post);
        let body = new HttpParams();
        const headers = new HttpHeaders();
        headers.set('content-type', 'application/x-www-form-urlencoded');
        body = body.set('postTitle', JSON.stringify(post.postTitle));
        body = body.set('postContent', post.postContent);
        body = body.set('token', localStorage.getItem('token'));
        this.http.post(this.auth.url + 'post.do', body, { headers: headers }).subscribe();
    }

}
