import { Payment } from './payment/payment';
import { Component, OnInit } from '@angular/core';
import { CustomerInfo } from '../login/user/CustomerInfo';

@Component({
  selector: 'app-paymentinfo',
  templateUrl: './paymentinfo.component.html',
  styleUrls: ['./paymentinfo.component.css']
})
export class PaymentinfoComponent implements OnInit {

  pInfos:Payment[] = [
    new Payment(null,1234123412341234,123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,1234123412341234,123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,1234123412341234,123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,1234123412341234,123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,1234123412341234,123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345)
  ];

  constructor() { }

  ngOnInit() {
  }

}
