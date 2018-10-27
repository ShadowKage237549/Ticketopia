import { TicketService } from './../../Services/Ticket/ticket.service';
import { Component, OnInit } from '@angular/core';
import { Ticket } from './ticket/ticket';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { async } from '@angular/core/testing';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-store',
    templateUrl: './store.component.html',
    styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {
    tickets: Ticket[];
    constructor(private ticketService: TicketService, private topicService: TopicService) { }

    selectStoreTicket(ticket: Ticket) {
        this.ticketService.selectedStoreTicket = ticket;
        this.topicService.selectedTopic = this.topicService.getTopicById(ticket.ticketId);
    }

    ngOnInit() {
        (async () => {
            this.ticketService.getTickets();
            await delay(1500);
            this.tickets = this.ticketService.tickets;
            console.log(this.tickets);
        })();

    }

}
