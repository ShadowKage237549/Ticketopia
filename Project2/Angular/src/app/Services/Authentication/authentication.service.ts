import { Router } from '@angular/router';
import { CustomerInfo } from '../../Components/login/user/CustomerInfo';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { async } from '@angular/core/testing';

async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Injectable({
    providedIn: 'root'
})

export class AuthenticationService {

    public url = 'http://18.222.219.232:8085/Ticketopia/';
    customerinfo: CustomerInfo = null;
    constructor(private http: HttpClient, private router: Router) { }

    login(email: string, password: string) {
        let body = new HttpParams();
        const headers = new HttpHeaders().set(
            'Content-Type', 'application/x-www-form-urlencoded'
        );
        body = body.set('email', email);
        body = body.set('password', password);
        this.http.post(this.url + 'LoginServlet', body, { headers: headers }).subscribe(data => this.storeToken(data));
    }

    storeToken(token: any) {
        if (token !== 'wrong info' && token != null) {

            (async () => {
                localStorage.setItem('token', token);
                await delay(500);
                this.requestCustomerData();
            })();

        }
    }
    logout() {
        localStorage.removeItem('token');
    }
    getToken() {
        const token = localStorage.getItem('token');
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
        const token = localStorage.getItem('token');
        this.http.get(this.url + 'customerInfo.do?token=' + token).subscribe((data: CustomerInfo) => this.customerinfo = data);
        (async () => {
            await delay(500);
            localStorage.setItem('displayName', this.customerinfo.displayName);
            localStorage.setItem('email', this.customerinfo.userEmail);
        })();

    }
}
