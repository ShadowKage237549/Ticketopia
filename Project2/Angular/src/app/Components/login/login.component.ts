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
    email: string;
    password: string;


    constructor(private auth: AuthenticationService) {
    }

    ngOnInit() {
    }

    logMeIn() {
       this.auth.login(this.email, this.password);
        console.log(this.auth.token);
        if (this.auth.token === 'wrong info') {
            this.auth.token = null;
            //put in routing to error page
        } else {
            //route to home page
        }
    }

}
