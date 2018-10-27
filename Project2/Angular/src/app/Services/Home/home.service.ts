import { async } from '@angular/core/testing';
import { AuthenticationService } from './../Authentication/authentication.service';
import { Partner } from './../../Components/home/partner/Partner';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  constructor(private http:HttpClient, private authService:AuthenticationService) { }

  partners:Partner[] = null;
  getPartners(){

      this.http.get(this.authService.url + "partner.do").subscribe((data: Partner[]) => this.partners = data);
 
  }
}
