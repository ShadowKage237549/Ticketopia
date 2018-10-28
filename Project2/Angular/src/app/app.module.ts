import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { appRoutes } from './routes';

import { AppComponent } from './app.component';
import { NavbarComponent } from './Components/navbar/navbar.component';
import { HomeComponent } from './Components/home/home.component';
import { ForumComponent } from './Components/forum/forum.component';
import { StoreComponent } from './Components/store/store.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './Components/login/login.component';
import { ForumtopicComponent } from './Components/forumtopic/forumtopic.component';
import { ForumpostComponent } from './Components/forumpost/forumpost.component';
import { TicketComponent } from './Components/ticket/ticket.component';
import { PaymentinfoComponent } from './Components/paymentinfo/paymentinfo.component';
import { RouterModule } from '@angular/router';
import { RegisterComponent } from './Components/register/register/register.component';

@NgModule({
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
        RegisterComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        RouterModule.forRoot(appRoutes, { useHash: true })
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    bootstrap: [AppComponent]
})
export class AppModule { }
