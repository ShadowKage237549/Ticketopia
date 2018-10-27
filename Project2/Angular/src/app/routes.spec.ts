import { AppComponent } from './app.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/compiler/src/core';
import { appRoutes } from './routes';
import { PaymentinfoComponent } from './Components/paymentinfo/paymentinfo.component';
import { TicketComponent } from './Components/ticket/ticket.component';
import { ForumpostComponent } from './Components/forumpost/forumpost.component';
import { ForumtopicComponent } from './Components/forumtopic/forumtopic.component';
import { LoginComponent } from './Components/login/login.component';
import { StoreComponent } from './Components/store/store.component';
import { ForumComponent } from './Components/forum/forum.component';
import { HomeComponent } from './Components/home/home.component';
import { Location } from '@angular/common';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule } from '@angular/forms';
import { TestBed, async, ComponentFixture, fakeAsync, tick } from '@angular/core/testing';
import { Router } from '@angular/router';
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