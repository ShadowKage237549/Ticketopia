import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppRoutingModule } from './routes';

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
        PaymentinfoComponent
    ],
    imports: [
        AppRoutingModule,
        BrowserModule,
        FormsModule,
        HttpClientModule,
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
