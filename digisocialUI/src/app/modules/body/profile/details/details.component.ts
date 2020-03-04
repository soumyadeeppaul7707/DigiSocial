import { Component, OnInit, ViewChild, Input, ElementRef } from '@angular/core';
import { ImageCroppedEvent } from 'ngx-image-cropper';
import { AuthService } from 'src/app/auth.service';
import { DatePipe } from '@angular/common';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
  providers: [DatePipe]
})
export class DetailsComponent implements OnInit {

  constructor(private authService: AuthService,
    private datePipe: DatePipe,
    private profileService: ProfileService) { }

  image: any = "assets/11.jpg";

  ngOnInit() {
    let profilepictureData = {
      "username": this.authService.getUsername()
    };
    this.profileService.profilePictureShow(profilepictureData).subscribe(
      data => {
        this.image = data.blobobject;
      },
      error => {
        console.log(error);
      }
    );
  }

  imageChangedEvent: any = '';
  croppedImage: any = '';

  fileChangeEvent(event: any): void {
    this.imageChangedEvent = event;
  }
  imageCropped(event: ImageCroppedEvent) {
    this.croppedImage = event.base64;
  }
  imageLoaded() {
    // show cropper
  }
  cropperReady() {
    // cropper ready
  }
  loadImageFailed() {
    // show message
  }


  upload() {
    let currentdatetime = this.datePipe.transform(new Date(), 'yyyy-MM-dd HH:mm:ss');
    let profilepictureData = {
      "username": this.authService.getUsername(),
      "imagefilename": "profilepicture",
      "uploadtime": currentdatetime,
      "ispostOrProfilepicture": 0,
      "blobobject": this.croppedImage
    };

    this.profileService.profilePictureUpload(profilepictureData).subscribe(
      data => {
        console.log(data);
        this.ngOnInit();
      },
      error => {
        console.log(error);
      }
    );

    console.log("upload clicked.. !!");
    console.log(profilepictureData);
  }

}
