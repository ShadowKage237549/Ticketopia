import { AuthenticationService } from '../../Services/Authentication/authentication.service';
import { User } from './../login/user/User';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  
  loggedIn:boolean;

  constructor(private auth:AuthenticationService) { }

  ngOnInit() {
    //This works, but the navbar does not get updated when changing the value
    this.auth.isLoggedIn.subscribe(loggedIn => this.loggedIn = loggedIn);
    console.log("TODO: IMPLEMENT AUTHENTICATION IN NAVBAR");
  }

}
