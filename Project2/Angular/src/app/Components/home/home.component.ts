import { Partner } from './partner/Partner';
import { HomeService } from './../../Services/Home/home.service';
import { Component, OnInit, SimpleChanges, OnChanges } from '@angular/core';
async function delay(ms: number) {
    return new Promise(resolve => setTimeout(resolve, ms));
}
@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnChanges {
    partners: Partner[];
    constructor(private homeService: HomeService) { }

    ngOnChanges(changes: SimpleChanges): void {
        if (this.partners != null) {
            this.partners = this.homeService.partners;
        }

    }
    ngOnInit() {
        (async () => {
            this.homeService.getPartners();
            setInterval(async () => { this.partners = this.homeService.partners; }, 100);
        })();
    }


}
