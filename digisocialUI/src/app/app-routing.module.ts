import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticationRoutingModule } from './modules/authentication/authentication-routing.module';
import { RecentsRoutingModule } from './modules/body/recents/recents-routing.module';
import { FriendsRoutingModule } from './modules/body/friends/friends-routing.module';

const routes: Routes = [
  {path:'recents',loadChildren:'./modules/body/recents/recents.module#RecentsModule'},
   {path:'authentication',loadChildren: './modules/authentication/authentication.module#AuthenticationModule'},
   {path:'friends',loadChildren:'./modules/body/friends/friends.module#FriendsModule'},
   {path:'', redirectTo: 'friends', pathMatch: 'full'}
   
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes), 
    AuthenticationRoutingModule,
    RecentsRoutingModule,
    FriendsRoutingModule 
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
