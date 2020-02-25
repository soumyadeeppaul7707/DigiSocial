import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';
import {
  NgbDateStruct,
  NgbCalendar,
  NgbDatepickerConfig
} from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [NgbDatepickerConfig, DatePipe]
})
export class SignupComponent implements OnInit {

  model: NgbDateStruct;
  // public currentdatetime: Date = new Date();
  public currentdatetime: any;


  constructor(private fb: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router,
    private calendar: NgbCalendar,
    private dateconfig: NgbDatepickerConfig,
    private datePipe: DatePipe) {

    // customize default values of datepickers used by this component tree
    dateconfig.minDate = { year: 1900, month: 1, day: 1 };
    dateconfig.maxDate = { year: 2020, month: 12, day: 31 };

    // days that don't belong to current month are not visible
    dateconfig.outsideDays = 'hidden';

  }

  signupForm = this.fb.group({
    firstname: [''],
    lastname: [''],
    username: [''],
    email: [''],
    mobilenumber: [''],
    dateofbirth: [''],
    password: [''],
    confirmpassword: ['']
  });


  ngOnInit() {

  }

  onSubmit() {

    this.signupForm.removeControl('confirmpassword');

    let birthdate = this.model.year + '-' + this.model.month + '-' + this.model.day + ' 00\:00\:00';
    this.signupForm.controls['dateofbirth'].setValue(birthdate);
    //console.log(this.signupForm.value.dateofbirth);
    //console.log(this.model.day + '-' + this.model.month + '-' + this.model.year);

    this.signupForm.addControl('joiningdatetime', this.fb.control(''));
    this.currentdatetime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
    this.signupForm.value.joiningdatetime = this.currentdatetime;

    console.log(this.signupForm.value);

    this.authenticationService.signupUser(this.signupForm.value).subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );




  }

}
