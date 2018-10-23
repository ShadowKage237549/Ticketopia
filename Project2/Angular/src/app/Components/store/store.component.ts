import { TicketService } from './../../Services/Ticket/ticket.service';
import { Component, OnInit } from '@angular/core';
import { Ticket } from './ticket/ticket';
@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {
  tickets:Ticket[];
  constructor(private ticketService:TicketService) { }

  selectStoreTicket(ticket:Ticket){
    this.ticketService.selectedStoreTicket = ticket;
  }

  ngOnInit() {
    this.tickets = this.ticketService.getTickets(false);
  }

}
