import { Component, OnInit, Directive, HostListener } from '@angular/core';
import { FriendandchatService } from '../friendandchat.service';


@Component({
  selector: 'app-searchfriends',
  templateUrl: './searchfriends.component.html',
  styleUrls: ['./searchfriends.component.css']
})

@Directive({
  selector: '[searchinput]'
})
export class SearchfriendsComponent implements OnInit {

  constructor(private searchfriendService: FriendandchatService) { }

  ngOnInit() {
  }

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
    let searchText = {
      "username": searchFriendName
    };
    this.searchfriendService.showUserList(searchText).subscribe(
      searchedUserDataList => {
        this.userData = searchedUserDataList;
        console.log(searchedUserDataList);
      },
      error => {
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