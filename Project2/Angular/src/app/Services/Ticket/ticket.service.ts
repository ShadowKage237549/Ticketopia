import { Ticket } from './../../Components/store/ticket/ticket';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationService } from '../Authentication/authentication.service';

@Injectable({
    providedIn: 'root'
})
export class TicketService {
    tickets: Ticket[];
    ticket: Ticket;

    constructor(private http: HttpClient, private auth: AuthenticationService) { }
    getTicketById(id: number) {
        this.http.get(this.auth.url + "ticket.do?id=" + id).subscribe((data: Ticket) => this.ticket = data);
    }


    //request pertains to whether you want to send a HTTP GET request.
    getTickets() {
        this.http.get(this.auth.url + "tickets.do").subscribe((data: Ticket[]) => this.tickets = data);
    }

}
