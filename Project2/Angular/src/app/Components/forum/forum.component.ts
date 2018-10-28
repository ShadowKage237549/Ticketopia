
import { Topic } from './../forumtopic/topic/topic';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TopicService } from '../../Services/Forumtopic/topic.service';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-forum',
    templateUrl: './forum.component.html',
    styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {

    constructor(private topicService: TopicService) { }
    //Each topic is an anchor which leads to the forumtopic.component

    topics: Topic[];
    selectForumtopic(topic: Topic) {
        this.topicService.selectedTopic = topic;
    }

    ngOnInit() {
        (async () => {
            this.topicService.getTopics();
            await delay(500);
            this.topics = this.topicService.topics;
            console.log(this.topics);
        })();
    }

}

