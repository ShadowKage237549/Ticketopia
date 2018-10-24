import { TicketService } from './../../Services/Ticket/ticket.service';
import { Component, OnInit } from '@angular/core';
import { Ticket } from './ticket/ticket';
import { TopicService } from '../../Services/Forumtopic/topic.service';
@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.css']
})
export class StoreComponent implements OnInit {
  tickets:Ticket[];
  constructor(private ticketService:TicketService, private topicService:TopicService) { }

  selectStoreTicket(ticket:Ticket){
    this.ticketService.selectedStoreTicket = ticket;
    this.topicService.selectedTopic = this.topicService.getTopicById(ticket.topicId);
  }

  ngOnInit() {
    this.tickets = this.ticketService.getTickets(false);
  }

}
