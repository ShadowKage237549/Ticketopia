import { TicketService } from './../../Services/Ticket/ticket.service';
import { Ticket } from './../store/ticket/ticket';
import { Component, OnInit } from '@angular/core';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { Topic } from '../forumtopic/topic/topic';
import { PostTitle } from '../forumpost/post/ForumPost';
import { ForumpostService } from '../../Services/ForumPost/forumpost.service';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-ticket',
    templateUrl: './ticket.component.html',
    styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
    ticket: Ticket;
    ticketId: number;
    topic: Topic;
    postTitles: PostTitle[];
    constructor(private ticketService: TicketService, private topicService: TopicService, private fps: ForumpostService) { }

    ngOnInit() {

        (async () => {
            this.ticket = this.ticketService.ticket;
            console.log(this.ticket);
            this.ticketId = Number.parseInt(localStorage.getItem("ticketId"), 10);
            this.topicService.getTopicById(this.ticketId);
            await delay(1000); console.log(this.topic);
            this.topic = this.topicService.selectedTopic;
            this.fps.getPostsById(this.ticketId);
            await delay(500);
            this.postTitles = this.fps.postTitles;
        })();
    }

}
