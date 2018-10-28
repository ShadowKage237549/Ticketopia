import { Injectable } from '@angular/core';
import { CustomerInfo } from '../../Components/login/user/CustomerInfo';
import { HttpParams, HttpHeaders, HttpClient } from '@angular/common/http';
import { AuthenticationService } from '../Authentication/authentication.service';

@Injectable({
    providedIn: 'root'
})
export class RegisterService {

    constructor(private http: HttpClient, private auth: AuthenticationService) { }


    register(customer: CustomerInfo) {

        let body = new HttpParams;
        let headers = new HttpHeaders;
        headers.set("content-type", "application/x-www-form-urlencoded");
        body = body.set("userEmail", customer.userEmail);
        body = body.set("displayName", customer.displayName);
        body = body.set("password", customer.password);
        body = body.set("userFName", customer.userFName);
        body = body.set("userLName", customer.userLName);
        body = body.set("role", customer.role.toString());
        body = body.set("userAddress", customer.userAddress);
        body = body.set("userCity", customer.userCity);
        body = body.set("userState", customer.userEmail);
        body = body.set("userZip", customer.userZip.toString());
        this.http.post(this.auth.url + "register.do", body, { headers: headers }).subscribe();
    }
}
