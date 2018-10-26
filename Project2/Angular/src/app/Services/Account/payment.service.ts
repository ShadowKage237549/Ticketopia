import { AuthenticationService } from './../Authentication/authentication.service';
import { Payment } from './../../Components/paymentinfo/payment/payment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {


  constructor(private http:HttpClient, private authService:AuthenticationService) { }



  updatePayment(payment: Payment) {
    return this.http.post<Payment[]>(this.authService.url + "updatePayment.do", payment);
  }


}
