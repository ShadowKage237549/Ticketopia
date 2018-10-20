import { User } from './../login/user/User';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  login:User;
  loggedIn:boolean = false;
  constructor(private hClient:HttpClient) { }

  ngOnInit() {
  }

}
