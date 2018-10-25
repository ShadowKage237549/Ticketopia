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
        password: '1', 
        accumulatedPoints: 15,
        displayName:"notbobbert93",
        userFName:"empty",
        userLName:"empty",
        role: new UserType(0,"basic"),
        userAddress:"empty",
        userCity:"empty",
        userState:"empty",
        userZip:123456,
     };

    private loggedIn = new BehaviorSubject<boolean>(false);
    get isLoggedIn() {
        return this.loggedIn.asObservable();
    }
    token: any;


    constructor(private http: HttpClient, private router: Router) { }

    login(authUser: CustomerInfo) {
        // TODO get token from API
        // return this.http.post<User>('/api/login',{email,password});
        //this.token = 
        console.log(this.http.post("localhost:8085/Ticketopia/login.do", "email=" + authUser.userEmail + "&password=" + authUser.password));
        if (authUser.userEmail === this.testuser.userEmail && authUser.password === this.testuser.password) {
            this.loggedIn.next(true);
            this.token = sign({ exp: Math.floor(Date.now() / 1000) + (60 * 60 * 24), data: this.testuser.userEmail },
                'secretPassword');
            console.log(this.token);
            this.logout();
            return this.token;
        }
        return null;
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
