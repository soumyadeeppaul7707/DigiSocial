import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticationRoutingModule } from './modules/authentication/authentication-routing.module';
import { RecentsRoutingModule } from './modules/body/recents/recents-routing.module';

const routes: Routes = [
  {path:'recents',loadChildren:'./modules/body/recents/recents.module#RecentsModule'},
   {path:'authentication',loadChildren: './modules/authentication/authentication.module#AuthenticationModule'},
   {path:'', redirectTo: 'recents', pathMatch: 'full'}
   
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes), 
    AuthenticationRoutingModule,
    RecentsRoutingModule 
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
