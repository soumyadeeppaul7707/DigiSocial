import { Component, OnInit, Directive, HostListener } from '@angular/core';
import { DashboardService } from '../dashboard.service';
import { AuthService } from 'src/app/auth.service';


@Component({
  selector: 'app-searchfriends',
  templateUrl: './searchfriends.component.html',
  styleUrls: ['./searchfriends.component.css']
})

@Directive({
  selector: '[searchinput]'
})
export class SearchfriendsComponent implements OnInit {

  constructor(
    private dashboardfriendService: DashboardService,
    private authService: AuthService
  ) { }

  ngOnInit() {
  }

  searchText: any;
  friend1stname: any;
  searchtext: any;
  word: string = null;
  userData: any = null;

  @HostListener('document:keypress', ['$event'])
  fetchSearchedWord(event: KeyboardEvent) {
    this.showWord(this.friend1stname + event.key);
  }

  theFriend(name: string) {
    this.friend1stname = name;
  }

  @debounce()
  showWord(searchFriendName: any) {
    console.log(searchFriendName);
    this.searchText = {
      "username": searchFriendName,
      "currentuser": this.authService.getUsername()
    };
    this.callShowUserList();
  }

  callShowUserList() {
    this.dashboardfriendService.showUserList(this.searchText).subscribe(
      searchedUserDataList => {
        console.log(searchedUserDataList);
        this.userData = searchedUserDataList;
      },
      error => {
        console.log(error);
      }
    );
  }

  sendFriendRequest(friend: string) {
    let friendData = {
      "username": this.authService.getUsername(),
      "friendname": friend
    };
    this.dashboardfriendService.sendFriendRequest(friendData).subscribe(
      data => {
        console.log("Friend Request Send..");
        this.callShowUserList();
      }, error => {
        console.log(error);
      }
    );

  }

}








export function debounce(delay: number = 2000): MethodDecorator {
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    const timeoutKey = Symbol();

    const original = descriptor.value;

    descriptor.value = function (...args) {
      clearTimeout(this[timeoutKey]);
      this[timeoutKey] = setTimeout(() => original.apply(this, args), delay);
    };

    return descriptor;
  };
}