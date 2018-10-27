import { AuthenticationService } from '../../Services/Authentication/authentication.service';
import { Component, OnInit } from '@angular/core';

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
        console.log(localStorage.getItem("token"));
        if (this.authService.isNotNull(localStorage.getItem("token"))) {
            return true;
        }
        return false;
    }
    logout() {
        this.authService.logout();

    }

}
