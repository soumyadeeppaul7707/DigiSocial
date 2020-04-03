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

  showFriendListUrl = 'http://localhost:6000/digisocial/friend/showfriendlist';

  constructor(private http: HttpClient) { }
  
  showFriendList(json): Observable<any> {
    return this.http.post<any>(this.showFriendListUrl, json, httpOptions);
  }

}
