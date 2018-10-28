import { Topic } from './../../Components/forumtopic/topic/topic';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../Authentication/authentication.service';
import { PostTitle } from '../../Components/forumpost/post/ForumPost';
import { post } from 'selenium-webdriver/http';

@Injectable({
    providedIn: 'root'
})
export class TopicService {
    topics: Topic[];
    selectedTopic: Topic;
    constructor(private http: HttpClient, private auth: AuthenticationService) { }
    getTopicById(id: number) {
        this.http.get(this.auth.url + "topic.do?topicId=" + id).subscribe((data: Topic) => this.selectedTopic = data);
    }

    getTopics() {
        this.http.get(this.auth.url + "topics.do").subscribe((data: Topic[]) => this.topics = data);
    }


}
