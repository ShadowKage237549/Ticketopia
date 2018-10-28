import { AuthenticationService } from './../Authentication/authentication.service';
import { Payment } from './../../Components/paymentinfo/payment/payment';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class PaymentService {

    update: boolean = false;
    //Add a button to either update or insert payment method. change this to true if update is clicked.
    constructor(private http: HttpClient, private authService: AuthenticationService) { }



    updatePayment(payment: Payment) {
        let body = new HttpParams();
        let header = new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded');
        body = body.set('payment', JSON.stringify(payment));
        body = body.set('update', JSON.stringify(this.update));
        return this.http.post<Payment[]>(this.authService.url + "updatePayment.do", payment);
    }


}