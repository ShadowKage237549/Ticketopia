import { Partner } from './../../Components/home/partner/Partner';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeService {
  url:string = "http://18.222.219.232:8085/Ticketopia/partner.do"
  constructor(private http:HttpClient) { }

  getPartners(){
    return this.http.get<Partner[]>(this.url);
  }
}
