import { UserType } from './../../Components/login/user/UserType';
import { Router } from '@angular/router';
import { CustomerInfo } from '../../Components/login/user/CustomerInfo';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
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
        let body = new HttpParams();
        let headers = new HttpHeaders().set(
            'Content-Type', 'application/x-www-form-urlencoded'
        );
        body = body.set('email', email);
        body = body.set('password', password);

        return this.http.post("http://localhost:8085/Ticketopia/LoginServlet",
            body,
            { headers: headers });
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
