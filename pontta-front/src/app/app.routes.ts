import { Routes } from '@angular/router'
import { HomePageComponent } from './components/home-page/home-page.component'
import { ClientListComponent } from './components/client/client-list/client-list.component'
import { ClientEditComponent } from './components/client/client-edit/client-edit.component'

export const routes: Routes = [
    { path: '', component: HomePageComponent },
    { path: 'client', component: ClientListComponent },
    { path: 'client/:id', component: ClientEditComponent }
]
