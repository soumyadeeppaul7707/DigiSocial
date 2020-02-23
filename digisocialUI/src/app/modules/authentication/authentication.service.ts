import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  loginurl = "http://localhost:8000/digisocial/user/login";
  signupurl = "http://localhost:8000/digisocial/user/signup";

  constructor(private http: HttpClient) { }

  loginUser(json): Observable<any> {
    return this.http.post<any>(this.loginurl, json, httpOptions);
  }

  signupUser(json): Observable<any> {
    return this.http.post<any>(this.signupurl, json, httpOptions);
  }

}
