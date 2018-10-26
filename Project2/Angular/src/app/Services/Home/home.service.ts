import { AuthenticationService } from './../Authentication/authentication.service';
import { Partner } from './../../Components/home/partner/Partner';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  constructor(private http:HttpClient, private authService:AuthenticationService) { }

  getPartners(){
    return this.http.get<Partner[]>(this.authService.url + "partner.do");
  }
}