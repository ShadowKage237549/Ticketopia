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

    logout() {
        this.token = null;
    }
    getToken() {
        if (this.token != null) {
            return this.token;
        }
    }
}
