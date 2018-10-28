import { Partner } from './partner/Partner';
import { HomeService } from './../../Services/Home/home.service';
import { Component, OnInit } from '@angular/core';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    partners: Partner[];
    constructor(private homeService: HomeService) { }

    ngOnInit() {
        (async () => {
            this.homeService.getPartners();
            await delay(500);
            this.partners = this.homeService.partners;
        })();
    }


}
