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
        //TODO delete this code before pushing
        if(email == "bob" && password == "1"){
            this.token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjdXN0b21lckluZm8iOiJDdXN0b21lckluZm9PYmplY3QiLCJjYXJkTnVtYmVyIjoiMTIzNCIsInNlY3VyaXR5Q29kZSI6MTIzLCJleHBpcmF0aW9uRGF0ZSI6IjE5LTMwIiwiYmlsbGluZ0FkZHJlc3MiOiIxMjNsbiIsImJpbGxpbmdDaXR5IjoiYmlsbGMiLCJiaWxsaW5nU3RhdGUiOiJiaWxscyIsImJpbGxpbmdaaXAiOiJiaWxseiJ9.Yii4UglR6ssDCIU92Z6igr_inz3bG73TuQ9Zu3Ui2EE";
            this.storeToken(this.token);
        }

        // TODO enable this code before pushing
        // this.http.post(this.url +"login.do?email=" + email + "&password=" + password, {})
        //     .subscribe((data: string) => this.token = data);
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
