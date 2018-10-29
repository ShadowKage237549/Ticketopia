import { PaymentService } from './../../Services/Account/payment.service';
import { Payment } from './payment/payment';
import { Component, OnInit, SimpleChanges, OnChanges } from '@angular/core';
import { async } from '@angular/core/testing';
import { AuthenticationService } from '../../Services/Authentication/authentication.service';

@Component({
    selector: 'app-paymentinfo',
    templateUrl: './paymentinfo.component.html',
    styleUrls: ['./paymentinfo.component.css']
})
export class PaymentinfoComponent implements OnInit, OnChanges {

    pInfo: Payment = null;

    regPay: Payment = {
        customerInfo: {
            userEmail: '',
            displayName: '',
            password: '',
            userFName: '',
            userLName: '',
            accumulatedPoints: 0,
            role: 0,
            userAddress: '',
            userCity: '',
            userState: '',
            userZip: 0,
        },
        cardNumber: 1111111111111111,
        securityCode: 111,
        expirationDate: '11/11',
        billingAddress: '',
        billingCity: '',
        billingState: '',
        billingZip: 12345,
    };
    update: boolean = false;
    constructor(private paymentService: PaymentService, private auth: AuthenticationService) { }
    ngOnChanges(changes: SimpleChanges): void {
        if (this.pInfo != null) {
            this.pInfo = this.paymentService.paymentMethod;
        }
    }

    ngOnInit() {
        this.auth.requestCustomerData();
        setInterval(() => { this.regPay.customerInfo = this.auth.customerinfo; }, 1000);
        this.paymentService.getPayment(localStorage.getItem('email'));
        setInterval(async () => { this.pInfo = this.paymentService.paymentMethod; }, 100);
    }

    updatePayment() {
        (async () => {
            if (this.pInfo != null) {
                this.update = true;
            }
            this.paymentService.updatePayment(this.regPay, this.update);
            this.pInfo = this.regPay;
        })();
    }

}
