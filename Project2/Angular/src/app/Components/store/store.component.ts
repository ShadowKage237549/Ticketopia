import { TicketService } from './../../Services/Ticket/ticket.service';
import { Component, OnInit, SimpleChanges, OnChanges } from '@angular/core';
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
export class StoreComponent implements OnInit, OnChanges {
    tickets: Ticket[];
    constructor(private ticketService: TicketService, private topicService: TopicService) { }

    selectStoreTicket(ticket: Ticket) {
        this.ticketService.ticket = ticket;
        localStorage.setItem("ticketId", ticket.ticketId.toString());

    }
    ngOnChanges(changes: SimpleChanges): void {
        if (this.tickets != null) {
            this.tickets = this.ticketService.tickets;
        }

    }
    ngOnInit() {
        (async () => {
            this.ticketService.getTickets();
            setInterval(async () => { this.tickets = this.ticketService.tickets; }, 100);

        })();

    }

}
