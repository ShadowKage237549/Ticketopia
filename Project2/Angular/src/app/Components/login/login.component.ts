import { AuthenticationService } from '../../Services/Authentication/authentication.service';
import { Component, OnInit } from '@angular/core';
import { CustomerInfo } from './user/CustomerInfo';
import { UserType } from './user/UserType';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],
    providers: [AuthenticationService]
})
export class LoginComponent implements OnInit {

    token: any = "";
    email: string;
    password: string;


    constructor(private auth: AuthenticationService) {
    }

    ngOnInit() {
    }

    logMeIn() {
        console.log(this.email + this.password);
        this.token = this.auth.login(this.email, this.password);
    }

}
