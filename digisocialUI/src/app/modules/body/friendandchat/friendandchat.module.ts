import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FriendsComponent } from './friends/friends.component';
import { FriendandchatRoutingModule } from './friendandchat-routing.module';
import { ChatComponent } from './chat/chat.component';
import { SearchfriendsComponent } from './searchfriends/searchfriends.component';
import { FriendandchatComponent } from './friendandchat.component';

@NgModule({
  declarations: [FriendsComponent, ChatComponent, SearchfriendsComponent, FriendandchatComponent],
  imports: [
    CommonModule,
    FriendandchatRoutingModule
  ],
  exports: [
    FriendsComponent,
    ChatComponent
  ]
})
export class FriendandchatModule { }
