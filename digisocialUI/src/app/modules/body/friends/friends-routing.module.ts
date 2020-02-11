import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FriendsComponent } from './friends/friends.component';

const routes: Routes = [
  {path: "", redirectTo: 'friends/friends', pathMatch: 'full'},
  {path: "friends", redirectTo: 'friends/friends', pathMatch: 'full'},
  {path: "friends/friends",component: FriendsComponent}  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FriendsRoutingModule { }
