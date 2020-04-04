import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth.service';
import { FriendandchatService } from '../friendandchat.service';

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrls: ['./friends.component.css']
})
export class FriendsComponent implements OnInit {

  friendList: any;
  friendData: any;
  friendnameInModal: string;

  constructor(private authService: AuthService, private friendandchatService: FriendandchatService) { }

  ngOnInit() {
    this.showFriendList();
  }

  showFriendList() {
    this.friendData = {
      "username": this.authService.getUsername()
    };
    this.getFriendList();
  }

  getFriendList() {
    this.friendandchatService.showFriendList(this.friendData).subscribe(
      friendDataList => {
        this.friendList = friendDataList;
        console.log(this.friendList);
        console.log("friend list displayed..");
      }, error => {
        console.log(error);
      }
    );
  }

  unfriendModal(friendname: string) {
    this.friendnameInModal = friendname;
  }

  unfriendUser(friendname: string) {
    console.log("This is friend ==>> " + friendname);
    let unfriendData = {
      "username": this.authService.getUsername(),
      "friendname": friendname
    }
    this.friendandchatService.unfriendUser(unfriendData).subscribe(
      data => {
        console.log("Unfriended one friend... !!!!!");
        this.getFriendList();
      }, error => {
        console.log(error);
      }
    );
  }
}
