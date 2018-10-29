import { AuthenticationService } from './../Authentication/authentication.service';
import { Payment } from './../../Components/paymentinfo/payment/payment';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root'
})
export class PaymentService {

    // Add a button to either update or insert payment method. change this to true if update is clicked.
    constructor(private http: HttpClient, private auth: AuthenticationService) { }
    paymentMethod: Payment;
    updatePayment(payment: Payment, update: boolean) {
        let body = new HttpParams();
        const header = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
        body = body.set('payment', JSON.stringify(payment));
        body = body.set('update', JSON.stringify(update));
        body = body.set('token', localStorage.getItem('token'));
        return this.http.post(this.auth.url + 'updatePayment.do', body, { headers: header }).subscribe();
    }

    getPayment(email: string) {
        this.http.get(this.auth.url + 'payment.do?email=' + email).subscribe((data: Payment) => this.paymentMethod = data);
    }

}
