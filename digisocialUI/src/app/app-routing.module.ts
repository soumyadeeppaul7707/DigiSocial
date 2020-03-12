import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticationRoutingModule } from './modules/authentication/authentication-routing.module';
import { RecentsRoutingModule } from './modules/body/recents/recents-routing.module';
import { FriendandchatRoutingModule } from './modules/body/friendandchat/friendandchat-routing.module';
import { ProfileRoutingModule } from './modules/body/profile/profile-routing.module';

const routes: Routes = [
  { path: 'recents', loadChildren: './modules/body/recents/recents.module#RecentsModule' },
  { path: 'authentication', loadChildren: './modules/authentication/authentication.module#AuthenticationModule' },
  { path: 'friends', loadChildren: './modules/body/friendandchat/friendandchat.module#FriendandchatModule' },
  { path: 'profile', loadChildren: './modules/body/profile/profile.module#ProfileModule' },
  { path: '', redirectTo: 'authentication', pathMatch: 'full' }

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    AuthenticationRoutingModule,
    RecentsRoutingModule,
    FriendandchatRoutingModule,
    ProfileRoutingModule
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
