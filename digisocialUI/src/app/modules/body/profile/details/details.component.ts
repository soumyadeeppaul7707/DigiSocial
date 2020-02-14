import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  changeListener($event): void {
    this.readThis($event.target);
    // imagecropModal.setTimeout(() => {

    // }, 3000);
  }

  image:any='assets/1.jpg';
  file: File = null;

  readThis(inputValue: any): void {
    this.file = inputValue.files[0];
    var myReader: FileReader = new FileReader();

    myReader.onloadend = (e) => {
      this.image = myReader.result;
    }
    myReader.readAsDataURL(this.file);

    

  }

  upload() {

    
    // let jsonData = ({
    //   "blobobject": this.image,
    //   "name": this.file.name
    // });

    // console.log(jsonData);

    // this.uiService.fileUpload(jsonData).subscribe(
    //   data => {
    //     console.log("Yayy ! done mannnn !!!!!!!!!!!!!");
    //   }
    // );
  }

}
