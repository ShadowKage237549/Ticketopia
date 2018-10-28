import { TicketService } from './../../Services/Ticket/ticket.service';
import { Ticket } from './../store/ticket/ticket';
import { Component, OnInit } from '@angular/core';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { Topic } from '../forumtopic/topic/topic';
import { ForumPost } from '../forumpost/post/ForumPost';
import { ForumpostService } from '../../Services/ForumPost/forumpost.service';

@Component({
    selector: 'app-ticket',
    templateUrl: './ticket.component.html',
    styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
    ticket: Ticket;
    topic: Topic;
    forumposts: ForumPost[];
    constructor(private ticketService: TicketService, private topicService: TopicService, private fps: ForumpostService) { }

    ngOnInit() {
        this.ticket = this.ticketService.ticket;
        this.topic = this.topicService.getTopicById(this.ticket.ticketId);
        this.forumposts = this.fps.getPostsById(this.topic.topicId);
    }

}
