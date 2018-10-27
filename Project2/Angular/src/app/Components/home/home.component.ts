import { Partner } from './partner/Partner';
import { HomeService } from './../../Services/Home/home.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { async } from '@angular/core/testing';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    partners: Partner[];
    constructor(private homeService: HomeService) { }

    ngOnInit() {
        // this.subscribeToPartners();
    }

    subscribeToPartners() {
        this.homeService.getPartners().subscribe((data: Partner[]) => this.partners = data);
    }

}
