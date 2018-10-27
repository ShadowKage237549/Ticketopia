import { Ticket } from './../../Components/store/ticket/ticket';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationService } from '../Authentication/authentication.service';

@Injectable({
    providedIn: 'root'
})
export class TicketService {
    selectedStoreTicket: Ticket;
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
            this.tickets = this.requestTickets();
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

    //HTTP://18.222.219.232:8085/Ticketopia/{Whatever it does .do}
    requestTickets() {
        //TODO make http.get

        return [new Ticket(
            1,
            "myTicketType",
            10,
            "myEventType",
            "myEventDescription",
            "12345 address ln",
            "City",
            "State",
            123456,
            "myPartnerName",
            1,
            true),
        new Ticket(2, "", 10, "", "", "", "", "", 123456, "", 2, false),
        new Ticket(3, "", 10, "", "", "", "", "", 123456, "", 3, false),
        new Ticket(4, "", 10, "", "", "", "", "", 123456, "", 4, false),
        new Ticket(5, "", 10, "", "", "", "", "", 123456, "", 5, false),
        new Ticket(6, "", 50, "", "", "", "", "", 123456, "", 6, false)];
    }
}
