import { AuthenticationService } from '../../Services/Authentication/authentication.service';
import { CustomerInfo } from '../login/user/CustomerInfo';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {



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

}
