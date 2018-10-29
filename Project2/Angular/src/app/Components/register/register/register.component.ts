import { Component, OnInit } from '@angular/core';
import { CustomerInfo } from '../../login/user/CustomerInfo';
import { RegisterService } from '../../../Services/register/register.service';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
    customer: CustomerInfo = {
        userEmail: '',
        displayName: '',
        password: '',
        userFName: '',
        userLName: '',
        accumulatedPoints: 0,
        role: 1,
        userAddress: '',
        userCity: '',
        userState: '',
        userZip: 12345,
    };
    constructor(private register: RegisterService) { }

    ngOnInit() {
    }

    registerAccount() {
        this.register.register(this.customer);
    }
}
