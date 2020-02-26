import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn : boolean = false;
  username : string;

  constructor() { }

  getUsername() {
    return this.username;
  }

  setUsername(username: any) {
    this.username = username;
  }



  login() {
    this.isLoggedIn = true;
  }

  logout() {
    this.isLoggedIn = false;
  }

}
