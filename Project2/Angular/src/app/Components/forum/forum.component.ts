
import { Topic } from './../forumtopic/topic/topic';
import { Component, OnInit, SimpleChanges, OnChanges } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { async } from '@angular/core/testing';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-forum',
    templateUrl: './forum.component.html',
    styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit, OnChanges {

    constructor(private topicService: TopicService) { }
    //Each topic is an anchor which leads to the forumtopic.component

    topics: Topic[];
    selectForumtopic(topic: Topic) {
        this.topicService.selectedTopic = topic;
    }

    ngOnChanges(changes: SimpleChanges): void {
        if (this.topics != null) {
            this.topics = this.topicService.topics;
        }

    }

    ngOnInit() {
        (async () => {
            this.topicService.getTopics();
            setInterval(async () => { this.topics = this.topicService.topics; }, 100);
        })();
    }

}

