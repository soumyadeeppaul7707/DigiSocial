import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}


@Injectable({
  providedIn: 'root'
})
export class FriendandchatService {
  getAllUserListUrl = 'http://localhost:9000/digisocial/friend/showusers';
  constructor(private http: HttpClient) { }

  showUserList(json): Observable<any> {
    return this.http.post<any>(this.getAllUserListUrl, json, httpOptions);
  }
}
