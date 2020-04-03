import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth.service';
import { FriendandchatService } from '../friendandchat.service';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {

  constructor(private authService: AuthService, private friendandchatService: FriendandchatService) { }

  ngOnInit() {
    this.showFriendList();
  }

  showFriendList() {
    let friendData = {
      "username": this.authService.getUsername()
    };

    this.friendandchatService.showFriendList(friendData).subscribe(
      friendDataList => {
        console.log("friend list displayed..");
      }, error => {
        console.log(error);
      }
    );
  }

}
