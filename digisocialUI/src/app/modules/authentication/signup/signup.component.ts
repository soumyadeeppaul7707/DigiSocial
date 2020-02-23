import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private fb: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router) { }


  signupForm = this.fb.group({
    firstname: [''],
    lastname: [''],
    username: [''],
    emailid: [''],
    mobilenumber: [''],
    dateofbirth: [''],
    password: [''],
    confirmpassword: ['']
  });


  ngOnInit() {
  }

  onSubmit() {
    // this.authenticationService.loginUser(this.signupForm.value).subscribe(
    //   data => {
    //     console.log(data);
    //   },
    //   error => {
    //     console.log(error);
    //   }
    // );


    this.signupForm.addControl('joiningdate', this.fb.control(''));
    this.signupForm.removeControl('confirmpassword');
    console.log(this.signupForm.value);
  }

}
