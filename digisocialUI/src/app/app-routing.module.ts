import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticationRoutingModule } from './modules/authentication/authentication-routing.module';
import { RecentsRoutingModule } from './modules/body/recents/recents-routing.module';
import { FriendsRoutingModule } from './modules/body/friends/friends-routing.module';
import { ProfileRoutingModule } from './modules/body/profile/profile-routing.module';

const routes: Routes = [
  { path: 'recents', loadChildren: './modules/body/recents/recents.module#RecentsModule' },
  { path: 'authentication', loadChildren: './modules/authentication/authentication.module#AuthenticationModule' },
  { path: 'friends', loadChildren: './modules/body/friends/friends.module#FriendsModule' },
  { path: 'profile', loadChildren: './modules/body/profile/profile.module#ProfileModule' },
  { path: '', redirectTo: 'authentication', pathMatch: 'full' }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    AuthenticationRoutingModule,
    RecentsRoutingModule,
    FriendsRoutingModule,
    ProfileRoutingModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
