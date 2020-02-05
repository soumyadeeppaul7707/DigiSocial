import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FriendsComponent } from './friends/friends.component';
import { ChatComponent } from './chat/chat.component';

@NgModule({
  declarations: [FriendsComponent, ChatComponent],
  imports: [
    CommonModule
  ]
})
export class FriendsModule { }
