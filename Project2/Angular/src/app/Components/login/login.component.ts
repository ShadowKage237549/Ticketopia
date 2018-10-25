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

    login: CustomerInfo = {
        userEmail:"empty",
        displayName:"empty",
        userFName:"empty",
        userLName:"empty",
        accumulatedPoints:0,
        role: new UserType(0,"basic"),
        userAddress:"empty",
        userCity:"empty",
        userState:"empty",
        userZip:123456,
        password:"empty",
    };
    constructor(private auth: AuthenticationService) {
    }

    ngOnInit() {
    }

    logMeIn() {
        this.login = this.auth.login(this.login);
    }

}
