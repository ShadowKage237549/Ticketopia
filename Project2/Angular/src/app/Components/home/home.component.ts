import { Partner } from './partner/Partner';
import { HomeService } from './../../Services/home/home.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  partners:Partner[];
  constructor(private homeService:HomeService) { }

  ngOnInit() {
    this.subscribeToPartners();
  }
  
  subscribeToPartners(){
    this.homeService.getPartners().subscribe((data: Partner[]) => this.partners = data);
  }

}
