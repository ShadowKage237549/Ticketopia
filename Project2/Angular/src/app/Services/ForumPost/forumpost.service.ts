import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../Authentication/authentication.service';
import { ForumPost } from 'src/app/Components/forumpost/post/ForumPost';

@Injectable({
    providedIn: 'root'
})
export class ForumpostService {
    forumposts: ForumPost[];
    constructor(private http: HttpClient, private auth: AuthenticationService) { }

    getPostsById(id: number) {
        this.http.get(this.auth.url + "postTitle.do?id=" + id).subscribe((data: ForumPost[]) => this.forumposts = data);
        return this.forumposts;
    }
}
