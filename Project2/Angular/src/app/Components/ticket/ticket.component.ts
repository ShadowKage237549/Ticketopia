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
    ticket: Ticket = this.getTicketById(Number.parseInt(this.activatedRoute.snapshot.url[2].path));
    ticketId: number;
    constructor(private router: Router, private activatedRoute: ActivatedRoute, private ticketService: TicketService) { }

    ngOnInit() {
        this.ticketId = Number.parseInt(this.activatedRoute.snapshot.url[2].path);
        this.ticket = this.ticketService.getTicketById(this.ticketId);

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
