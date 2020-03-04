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
export class ProfileService {

  profilepictureuploadurl = "http://localhost:7000/digisocial/profile/profilepictureupload";
  profilepictureshowurl = "http://localhost:7000/digisocial/profile/showprofilepicture";

  constructor(private http: HttpClient) { }

  profilePictureUpload(json): Observable<any> {
    return this.http.post<any>(this.profilepictureuploadurl, json, httpOptions);
  }

  profilePictureShow(json): Observable<any> {
    return this.http.post<any>(this.profilepictureshowurl, json, httpOptions);
  }
}
