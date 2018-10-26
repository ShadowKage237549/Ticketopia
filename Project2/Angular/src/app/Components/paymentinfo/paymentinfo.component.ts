import { PaymentService } from './../../Services/Account/payment.service';
import { Payment } from './payment/payment';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-paymentinfo',
  templateUrl: './paymentinfo.component.html',
  styleUrls: ['./paymentinfo.component.css']
})
export class PaymentinfoComponent implements OnInit {

  pInfos:Payment[] = [
    new Payment(null,"1234123412341234",123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,"1234123412341234",123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,"1234123412341234",123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,"1234123412341234",123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345),
    new Payment(null,"1234123412341234",123,"expirationDate"," 12345 billingAddress","billingCity","billingState",12345)
  ];
  registerPayment:Payment = new Payment(null,null,null,null,null,null,null,null);

  constructor(private paymentService:PaymentService) { }

  ngOnInit() {
  }

  registerNewPayment(){
    if(this.registerPayment != null){
      //this.pInfos.push(this.registerPayment);
      //this.paymentService.updatePayment(this.pInfos);
      console.log(this.registerPayment);
    }

  }

}
