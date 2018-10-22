import { Router } from '@angular/router';
import { User } from './../Components/login/user/User';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { sign } from 'jsonwebtoken';
@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    testuser: User = { email: 'bobbert', password: '1', points: 15 };

    private loggedIn = new BehaviorSubject<boolean>(false);
    get isLoggedIn() {
        return this.loggedIn.asObservable();
    }
    token: any;


    constructor(private http: HttpClient, private router: Router) { }

    login(authUser: User) {
        // TODO get token from API
        // return this.http.post<User>('/api/login',{email,password});
        if (authUser.email === this.testuser.email && authUser.password === this.testuser.password) {
            this.loggedIn.next(true);
            this.token = sign({ exp: Math.floor(Date.now() / 1000) + (60 * 60 * 24), data: this.testuser.email },
                'secretPassword');
            console.log(this.token);
            this.logout();
            return this.token;
        }
        return null;
    }
    logout() {
        this.loggedIn.next(false);
    }
    getToken() {
        if (this.loggedIn) {
            return this.token;
        }
    }
}
