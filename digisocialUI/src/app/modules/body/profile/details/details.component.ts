import { Component, OnInit, ViewChild, Input, ElementRef } from '@angular/core';
import { ImageCroppedEvent } from 'ngx-image-cropper';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  
  // changeListener($event): void {
  //   this.readThis($event.target);
  // }

  // profileimage:any='assets/1.jpg';
  // file: File = null;


  

  // public imageDestination: string;

  // readThis(inputValue: any): void {
  //   this.file = inputValue.files[0];
  //   var myReader: FileReader = new FileReader();

  //   myReader.onloadend = (e) => {
  //     this.profileimage = myReader.result;
  //   }
  //   myReader.readAsDataURL(this.file);
  // }


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
  }

}
