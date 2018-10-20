import { Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { ForumComponent } from './Components/forum/forum.component';
import { ForumtopicComponent } from './Components/forumtopic/forumtopic.component';
import { StoreComponent } from './Components/store/store.component';
import { LoginComponent } from './Components/login/login.component';
import { ForumpostComponent } from './Components/forumpost/forumpost.component';

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
        path: 'home/store',
        component: StoreComponent
    },
    {
        path: 'forum',
        component: ForumComponent
    },
    {
        path: 'forum/:topic',
        component: ForumtopicComponent
    },
    {
        path: 'forum/:topic/:post',
        component: ForumpostComponent
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
        redirectTo: 'home',
        pathMatch: 'full'
    }
];
