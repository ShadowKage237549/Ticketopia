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

        //Check if the tickets are available.
        if (this.tickets == null) {
            //If the tickets are not available, get the tickets
            //if the tickets are still null, the request failed.
            if (this.tickets == null) {
                return null;
            }
        }

        //Check if the tickets array contains the required ticket
        if (this.tickets[id] == null) {
            //if it does not, request the tickets again.
        }
        //If the ticket is still null, then just return null.
        if (this.tickets[id - 1] != null) {
            return this.tickets[id - 1];
        }
        return null;
    }


    //request pertains to whether you want to send a HTTP GET request.
    getTickets() {
        this.http.get(this.auth.url + "ticket.do").subscribe((data: Ticket[]) => this.tickets = data);
    }

}
