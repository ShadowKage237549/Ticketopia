import { User } from './../Components/login/user/User';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  testuser: User = { email: "bobbert", password: "1", points: 15 };
  loggedIn: boolean = false;
  constructor(private http: HttpClient) { }

  login(authUser: User) {
    //return this.http.post<User>('/api/login',{email,password});
    if (authUser.email == this.testuser.email && authUser.password == this.testuser.password) {
      this.loggedIn = true;
      return this.testuser;
    }
    return null;
  }
  logout() {
    this.loggedIn = false;
  }
}
