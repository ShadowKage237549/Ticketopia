import { PaymentinfoComponent } from './Components/paymentinfo/paymentinfo.component';
import { TicketComponent } from './Components/ticket/ticket.component';
import { ForumpostComponent } from './Components/forumpost/forumpost.component';
import { ForumtopicComponent } from './Components/forumtopic/forumtopic.component';
import { LoginComponent } from './Components/login/login.component';
import { StoreComponent } from './Components/store/store.component';
import { ForumComponent } from './Components/forum/forum.component';
import { HomeComponent } from './Components/home/home.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { appRoutes } from './routes';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AppComponent } from './app.component';
import { RouterTestingModule } from '@angular/router/testing';
import { Location } from '@angular/common';
import { ComponentFixture, async, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/compiler/src/core';
describe('RoutingUnitTest', () => {
    let component: AppComponent;
    let fixture: ComponentFixture<AppComponent>;
    let router: Router;
    let location: Location;

    beforeEach(async(() => {
      TestBed.configureTestingModule({
        imports: [
          FormsModule, 
          RouterTestingModule.withRoutes(appRoutes),
          HttpClientModule],
        declarations: [
          AppComponent,
          NavbarComponent,
          HomeComponent,
          ForumComponent,
          StoreComponent,
          LoginComponent,
          ForumtopicComponent,
          ForumpostComponent,
          TicketComponent,
          PaymentinfoComponent,
        ],
        schemas: [CUSTOM_ELEMENTS_SCHEMA]
      }).compileComponents();
      router = TestBed.get(Router);
      location = TestBed.get(Location);
    }));

    beforeEach(() => {
      fixture = TestBed.createComponent(AppComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });

    it('navigate to "" redirects to /Ticketopia/home', fakeAsync(() => {
      router.navigate(['']);
      tick();
      expect(location.path()).toBe('/Ticketopia/home');
    }));
});