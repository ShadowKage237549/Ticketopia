import { PaymentinfoComponent } from './Components/paymentinfo/paymentinfo.component';
import { TicketComponent } from './Components/ticket/ticket.component';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { ForumComponent } from './Components/forum/forum.component';
import { ForumtopicComponent } from './Components/forumtopic/forumtopic.component';
import { StoreComponent } from './Components/store/store.component';
import { LoginComponent } from './Components/login/login.component';
import { ForumpostComponent } from './Components/forumpost/forumpost.component';
import { NgModule } from '@angular/core';

export const appRoutes: Routes = [
    {
        path: 'Ticketopia/login',
        component: LoginComponent
    },
    {
        path: 'Ticketopia/store',
        component: StoreComponent
    },
    {
        path: 'Ticketopia/paymentinfo',
        component: PaymentinfoComponent
    },
    {
        path: 'Ticketopia/store/ticket/:ticketId',
        component: TicketComponent
    },
    {
        path: 'Ticketopia/home/store',
        component: StoreComponent
    },
    {
        path: 'Ticketopia/forum',
        component: ForumComponent
    },
    {
        path: 'Ticketopia/forum/:topic',
        component: ForumtopicComponent
    },
    {
        path: 'Ticketopia/forum/:topic/:post',
        component: ForumpostComponent
    },
    {
        path: 'Ticketopia',
        component: HomeComponent
    },
    {
        path: 'Ticketopia/home',
        component: HomeComponent
    },
    {
        path: '**',
        redirectTo: 'Ticketopia/home',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes,
        )
    ],
    exports: [
        RouterModule
    ],
})
export class AppRoutingModule { }
