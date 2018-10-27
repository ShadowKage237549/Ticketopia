import { AuthenticationService } from '../../Services/Authentication/authentication.service';
import { Component, OnInit } from '@angular/core';

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
        if (this.auth.getToken() == null) {
            //route to err page
        } else {
            //route to home page
            this.auth.requestCustomerData();
        }
    }

}
