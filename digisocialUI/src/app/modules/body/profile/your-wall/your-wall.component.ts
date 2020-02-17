import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-your-wall',
  templateUrl: './your-wall.component.html',
  styleUrls: ['./your-wall.component.css']
})
export class YourWallComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  changeListener($event: any): void {
    this.readThis($event.target);
    console.log("this is calleddhgffgfgnfngfnmghg");
  }

  
  postimage: any;
  file: File = null;
  readThis(inputValue: any): void {
    this.file = inputValue.files[0];
    var myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.postimage = myReader.result;
      console.log(myReader.result);
    }
    myReader.readAsDataURL(this.file);
  }


  upload() {

  }

}
