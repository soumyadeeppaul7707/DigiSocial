import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FriendandchatComponent } from './friendandchat.component';

const routes: Routes = [
  // {path: "", redirectTo: 'friends/friends', pathMatch: 'full'},
  { path: "friends", redirectTo: 'friends/friends', pathMatch: 'full' },
  { path: "friends/friends", component: FriendandchatComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FriendandchatRoutingModule { }
