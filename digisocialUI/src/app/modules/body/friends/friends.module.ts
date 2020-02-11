import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FriendsComponent } from './friends/friends.component';
import { FriendsRoutingModule } from './friends-routing.module';

@NgModule({
  declarations: [FriendsComponent],
  imports: [
    CommonModule,
    FriendsRoutingModule
  ],
  exports: [
    FriendsComponent
  ]
})
export class FriendsModule { }
