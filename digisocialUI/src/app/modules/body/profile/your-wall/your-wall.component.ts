import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth.service';
import { DatePipe } from '@angular/common';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-your-wall',
  templateUrl: './your-wall.component.html',
  styleUrls: ['./your-wall.component.css'],
  providers: [DatePipe]
})
export class YourWallComponent implements OnInit {

  constructor(private authService: AuthService,
    private datePipe: DatePipe,
    private profileService: ProfileService) { }

  ngOnInit() {
    this.showPosts();
  }

  changeListener($event: any): void {
    this.readThis($event.target);
  }
posts:any;
  postcaption: any;
  postimage: any;
  file: File = null;
  readThis(inputValue: any): void {
    this.file = inputValue.files[0];
    var myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.postimage = myReader.result;
    }
    myReader.readAsDataURL(this.file);
  }


  upload() {
    let currentdatetime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
    let postData = ({
      "username": this.authService.getUsername(),
      "caption": this.postcaption,
      "imagefilename": this.file.name,
      "uploadtime": currentdatetime,
      "ispost": 1,
      "blobobject": this.postimage
    });

    this.profileService.postUpload(postData).subscribe(
      data => {
        //console.log(data);
        this.showPosts();
      },
      error => {
        console.log(error);
      }
    );
  }


  showPosts() {
    let postData = {
      "username": this.authService.getUsername()
    };
    this.profileService.postShow(postData).subscribe(
      postdata => {
        this.posts = postdata ;
        //this.postimage = data.blobobject;
      },
      error => {
        console.log(error);
      }
    );
  }

}
