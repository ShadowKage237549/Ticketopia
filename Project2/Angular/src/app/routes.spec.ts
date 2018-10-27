import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Location } from '@angular/common';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { TestBed, async, ComponentFixture, fakeAsync, tick } from '@angular/core/testing';
import { Router } from '../../node_modules/@angular/router';
import { appRoutes } from './routes';
import { ForumComponent } from './Components/forum/forum.component';
import { HomeComponent } from './Components/home/home.component';
import { LoginComponent } from './Components/login/login.component';
import { StoreComponent } from './Components/store/store.component';
import { ForumpostComponent } from './Components/forumpost/forumpost.component';
import { ForumtopicComponent } from './Components/forumtopic/forumtopic.component';
import { TicketComponent } from './Components/ticket/ticket.component';
import { PaymentinfoComponent } from './Components/paymentinfo/paymentinfo.component';

describe('RoutingUnitTest', () => {
    let component: AppComponent;
    let fixture: ComponentFixture<AppComponent>;
    let router: Router;
    let location: Location;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [FormsModule,
                RouterTestingModule.withRoutes(appRoutes),
                HttpClientModule],
            declarations: [AppComponent,
                NavbarComponent,
                HomeComponent,
                ForumComponent,
                StoreComponent,
                LoginComponent,
                ForumtopicComponent,
                ForumpostComponent,
                TicketComponent,
                PaymentinfoComponent],
            schemas: [CUSTOM_ELEMENTS_SCHEMA]
        })
            .compileComponents();
        router = TestBed.get(Router);
        location = TestBed.get(Location);
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(AppComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('navigate to "" redirects to /Ticketopia/home', fakeAsync(() => {
        router.navigate(['']); //invokes the router change
        tick(); //A Wait for promises to be resolved
        expect(location.path()).toBe('/Ticketopia/home');
    }));
});

