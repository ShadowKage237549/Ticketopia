import { UserType } from './../../Components/login/user/UserType';
import { Router } from '@angular/router';
import { CustomerInfo } from '../../Components/login/user/CustomerInfo';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { sign } from 'jsonwebtoken';
@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    testuser: CustomerInfo = {
        userEmail: 'bobbert',
        accumulatedPoints: 15,
        displayName: "notbobbert93",
        userFName: "empty",
        userLName: "empty",
        role: new UserType(0, "basic"),
        userAddress: "empty",
        userCity: "empty",
        userState: "empty",
        userZip: 123456,
    };
    password: string = "1";

    private loggedIn = new BehaviorSubject<boolean>(false);
    get isLoggedIn() {
        return this.loggedIn.asObservable();
    }
    token: any;


    constructor(private http: HttpClient, private router: Router) { }

    login(email: string, password: string) {

        this.http.post("http://18.222.219.232:8085/Ticketopia/login.do", "email=" + email + "&password=" + password)
            .subscribe((data: string) => this.token = data);
        return this.token;
    }
    logout() {
        this.loggedIn.next(false);
        this.token = "";
    }
    getToken() {
        if (this.loggedIn) {
            return this.token;
        }
    }
}
