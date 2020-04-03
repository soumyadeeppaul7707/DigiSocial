import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private fb: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router,
    private authService: AuthService) { }

  ngOnInit() {
  }

  loginForm = this.fb.group({
    username: [''],
    password: ['']
  });

  onSubmit() {
    this.authenticationService.loginUser(this.loginForm.value).subscribe(
      data => {
        console.log(data);
        if (data.authenticate) {
          this.authService.login();
          this.authService.setUsername(data.user.username);
          this.router.navigate(['/friends']);
        }
      },
      error => {
        console.log(error);
      }
    );
  }


}
