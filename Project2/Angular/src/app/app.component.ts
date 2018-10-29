import { Component, AfterViewInit, ElementRef, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit, OnInit {
    title = 'Ticketopia';

    constructor(private elementRef: ElementRef, private _router: Router) {

    }
    ngOnInit() {
        this._router.routeReuseStrategy.shouldReuseRoute = function () {
            return false;
        };

        this._router.events.subscribe((evt) => {
            if (evt instanceof NavigationEnd) {
                this._router.navigated = false;
            }
        });
    }
    ngAfterViewInit() {
        this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = "#cdcdcd";
    }
}
