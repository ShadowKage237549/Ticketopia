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
  regPay:Payment = new Payment(null,null,null,null,null,null,null,null);

  constructor(private paymentService:PaymentService) { }

  ngOnInit() {
  }

  updateExistingPayment(payment:Payment){
    if(payment != null){
      this.paymentService.updatePayment(this.regPay).subscribe((data:Payment[]) => this.pInfos);
    }
  }
  registerNewPayment(){
    if(this.regPay != null){
      this.paymentService.updatePayment(this.regPay).subscribe((data:Payment[]) => this.pInfos);
    }

  }

}
