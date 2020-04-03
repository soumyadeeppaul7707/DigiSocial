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
export class DashboardService {

  getAllUserListUrl = 'http://localhost:9000/digisocial/friend/showusers';
  sendFriendRequestUrl = 'http://localhost:9000/digisocial/friend/sendrequest';
  requestReceivedUrl = 'http://localhost:9000/digisocial/friend/requestreceived';
  acceptFriendRequestUrl = 'http://localhost:9000/digisocial/friend/acceptfriendrequest';
  rejectFriendRequestUrl = 'http://localhost:9000/digisocial/friend/rejectfriendrequest';

  constructor(private http: HttpClient) { }

  showUserList(json): Observable<any> {
    return this.http.post<any>(this.getAllUserListUrl, json, httpOptions);
  }

  sendFriendRequest(json): Observable<any> {
    return this.http.post<any>(this.sendFriendRequestUrl, json, httpOptions);
  }

  requestReceived(json): Observable<any> {
    return this.http.post<any>(this.requestReceivedUrl, json, httpOptions);
  }

  acceptFriendRequest(json): Observable<any> {
    return this.http.post<any>(this.acceptFriendRequestUrl, json, httpOptions);
  }

  rejectFriendRequest(json): Observable<any> {
    return this.http.post<any>(this.rejectFriendRequestUrl, json, httpOptions);
  }

}
