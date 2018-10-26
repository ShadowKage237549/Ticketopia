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

    public url: string = "http://localhost:8085/Ticketopia/";
    password: string = "1";
    customerinfo: CustomerInfo = null;
    constructor(private http: HttpClient, private router: Router) { }

    login(email: string, password: string) {
        let body = new HttpParams();
        let headers = new HttpHeaders().set(
            'Content-Type', 'application/x-www-form-urlencoded'
        );
        body = body.set('email', email);
        body = body.set('password', password);
        this.http.post(this.url + 'LoginServlet', body, { headers: headers }).subscribe(data => this.storeToken(data));
    }
    storeToken(token: any) {
        if (token != 'wrong info' && token != null) {
            localStorage.setItem("token", token);
            console.log(localStorage.getItem("token"));
        }
    }
    logout() {
        localStorage.removeItem("token");
    }
    getToken() {
        let token = localStorage.getItem("token");
        if (token != null) {
            return token;
        }
    }
    isNotNull(token: any): boolean {
        if (token != null) {
            return true;
        }
        return false;
    }
    requestCustomerData() {
        let token = localStorage.getItem("token");
        if (token != null) {
            this.http.get(this.url + "customerInfo.do?token=" + token).subscribe((data: CustomerInfo) => this.customerinfo = data);
        }

    }
}
