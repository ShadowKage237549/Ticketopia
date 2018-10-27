import { AuthenticationService } from '../../Services/Authentication/authentication.service';
import { Component, OnInit } from '@angular/core';
import { async } from '@angular/core/testing';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


    displayName = localStorage.getItem("displayName");
    constructor(private authService: AuthenticationService) { }

    ngOnInit() {
    }

    isNotNull() {
        (async () => {
            return this.authService.isNotNull(localStorage.getItem("token"));
        })();
    }
    logout() {
        this.authService.logout();

    }

}
