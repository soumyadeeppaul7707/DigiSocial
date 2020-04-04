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

  showFriendListUrl = 'http://localhost:9500/digisocial/friend/showfriendlist';
  unfriendUrl = 'http://localhost:9500/digisocial/friend/unfrienduser';

  constructor(private http: HttpClient) { }

  showFriendList(json): Observable<any> {
    return this.http.post<any>(this.showFriendListUrl, json, httpOptions);
  }

  unfriendUser(json): Observable<any> {
    return this.http.post<any>(this.unfriendUrl, json, httpOptions);
  }

}
