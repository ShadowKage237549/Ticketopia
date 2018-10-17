import { HomeComponent } from './Components/home/home.component';
import { ForumComponent } from './Components/forum/forum.component';
import { Routes } from "@angular/router";
import { StoreComponent } from './Components/store/store.component';
import { LoginComponent } from './Components/login/login.component';

export const appRoutes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'store',
        component: StoreComponent
    },
    {
        path: 'forum',
        component: ForumComponent
    },
    {
        path: '',
        component: HomeComponent
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: '**',
        redirectTo:'home',
        pathMatch: 'full'
    }
];