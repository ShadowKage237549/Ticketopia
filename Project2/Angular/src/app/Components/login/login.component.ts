import { AuthenticationService } from './../../Services/authentication.service';
import { Component, OnInit } from '@angular/core';
import { User } from './user/User';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],
    providers: [AuthenticationService]
})
export class LoginComponent implements OnInit {

    login: User = {
        email: '',
        password: '',
        points: 0
    };
    constructor(private auth: AuthenticationService) {
    }

    ngOnInit() {
    }

    logMeIn() {
        this.login = this.auth.login(this.login);
    }

}
