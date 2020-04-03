import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth.service';
import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'app-friendrequestsreceived',
  templateUrl: './friendrequestsreceived.component.html',
  styleUrls: ['./friendrequestsreceived.component.css']
})
export class FriendrequestsreceivedComponent implements OnInit {

  constructor(private authService: AuthService, private dashboardService: DashboardService) { }

  ngOnInit() {
    this.friendRequestsReceived();
  }
  checkIfReceivedAnyFriendRequest:any;
  friendRequestReceiveDataList: any = null;


  friendRequestsReceived() {
    this.checkIfReceivedAnyFriendRequest = {
      "username": this.authService.getUsername(),
      "friendrequeststatus": "r"
    }
    this.checkCurrentFriendRequestPending();
  }

  checkCurrentFriendRequestPending(){
    this.dashboardService.requestReceived(this.checkIfReceivedAnyFriendRequest).subscribe(
      requestReceivedList => {
        this.friendRequestReceiveDataList = requestReceivedList;
      }
    );
  }

  acceptFriendRequest(friendname: string) {
    let acceptFRequestData = {
      "username": this.authService.getUsername(),
      "friendname": friendname
    }
    this.dashboardService.acceptFriendRequest(acceptFRequestData).subscribe(
      data => {
        console.log("Friend Request Accepted");
        this.checkCurrentFriendRequestPending();
      }, error => {
        console.log(error);
      }
    );
  }

  rejectFriendRequest(friendname: string) {
    let rejectFRequestData = {
      "username": this.authService.getUsername(),
      "friendname": friendname
    }
    this.dashboardService.rejectFriendRequest(rejectFRequestData).subscribe(
      data => {
        console.log("Friend Request Rejected");
        this.checkCurrentFriendRequestPending();
      }, error => {
        console.log(error);
      }
    );
  }
}
