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
    //Use this throughout the angular application.
    public url:string = "http://18.222.219.232:8085/Ticketopia/";
    password: string = "1";
    token: any = null;



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
            { headers: headers }).subscribe(data => this.token = data);
    }
    storeToken(token: any) {
        localStorage.setItem("token",this.token);
        console.log(localStorage.getItem("token"));
    }
    logout() {
        this.token = null;
    }
    getToken() {
        if (this.token != null) {
            return this.token;
        }
    }
}
