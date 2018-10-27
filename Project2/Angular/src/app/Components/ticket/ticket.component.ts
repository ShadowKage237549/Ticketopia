import { TicketService } from './../../Services/Ticket/ticket.service';
import { Ticket } from './../store/ticket/ticket';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-ticket',
    templateUrl: './ticket.component.html',
    styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {
    ticket: Ticket;
    constructor(private ticketService: TicketService) { }

    ngOnInit() {
        this.ticket = this.ticketService.ticket;
    }

    getTicketById(id: number) {
        if (this.ticketService.selectedStoreTicket != null) {
            if (id == this.ticketService.selectedStoreTicket.ticketId) {
                this.ticket = this.ticketService.selectedStoreTicket;
            } else {
                this.ticket = this.ticketService.getTicketById(id);
            }
            return this.ticket;
        }
    }
}
