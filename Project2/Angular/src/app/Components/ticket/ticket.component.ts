import { TicketService } from './../../Services/Ticket/ticket.service';
import { Ticket } from './../store/ticket/ticket';
import { Component, OnInit, SimpleChanges, OnChanges } from '@angular/core';
import { TopicService } from '../../Services/Forumtopic/topic.service';
import { Topic } from '../forumtopic/topic/topic';
import { PostTitle } from '../forumpost/post/ForumPost';
import { ForumpostService } from '../../Services/ForumPost/forumpost.service';
import { ActivatedRoute } from '@angular/router';
import { PaymentService } from 'src/app/Services/Account/payment.service';
import { Payment } from '../paymentinfo/payment/payment';
@Component({
    selector: 'app-ticket',
    templateUrl: './ticket.component.html',
    styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit, OnChanges {
    ticket: Ticket = null;
    ticketId: number = null;
    topic: Topic = null;
    postTitles: PostTitle[] = null;
    purchased: boolean = false;
    paymentMethod: Payment;
    // tslint:disable-next-line:max-line-length
    constructor(private payment: PaymentService, private ticketService: TicketService, private topicService: TopicService, private fps: ForumpostService, private ar: ActivatedRoute) { }
    ngOnChanges(changes: SimpleChanges): void {
        if (this.ticket != null) {
            this.ticket = this.ticketService.ticket;
        }
        if (this.topic != null) {
            this.topic = this.topicService.selectedTopic;
        }
        if (this.postTitles != null) {
            this.postTitles = this.fps.postTitles;
        }
    }
    ngOnInit() {

        (async () => {
            this.ticket = this.ticketService.ticket;
            if (this.ticket != null) {
                this.ticketId = this.ticket.ticketId;
            } else {
                this.ticketId = Number.parseInt(this.ar.snapshot.url[3].path, 10);
                this.ticketService.getTicketById(this.ticketId);
                setInterval((async () => { this.ticket = this.ticketService.ticket; }), 100);
                this.payment.getPayment(localStorage.getItem("email"));
                setInterval((async () => { this.paymentMethod = this.payment.paymentMethod; }), 300);
            }

            this.topicService.getTopicById(this.ticketId);
            setInterval((async () => { this.topic = this.topicService.selectedTopic; }), 100);
            this.fps.getPostsById(this.ticketId);
            setInterval((async () => { this.postTitles = this.fps.postTitles; }), 100);
        })();
    }
    loggedIn() {
        if (localStorage.getItem('token')) {
            return true;
        }
        return false;
    }
    isPurchased() {
        return this.purchased;
    }

    purchase() {
        this.purchased = true;
    }

    hasPaymentMethod() {
        if (this.payment.paymentMethod == null) {
            return false;
        }
        return true;
    }
}
