import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
  }

  onSubmit(){
    console.log("signup clicked.");
  }

  signupForm= this.fb.group({
    firstname: [''],
    lastname: [''],
    username: [''],
    emailid: [''],
    mobilenumber: [''],
    dateofbirth: [''],
    password: [''],
    confirmpassword: ['']
  });

}
