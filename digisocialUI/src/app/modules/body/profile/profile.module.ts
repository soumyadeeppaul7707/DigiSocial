import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DetailsComponent } from './details/details.component';
import { YourWallComponent } from './your-wall/your-wall.component';
import { ProfileRoutingModule } from './profile-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { ProfileComponent } from './profile.component';
import { ImageCropperModule } from 'ngx-image-cropper';
import { ProfileService } from './profile.service';

@NgModule({
  declarations: [DetailsComponent, YourWallComponent, ProfileComponent],
  imports: [
    CommonModule,
    ProfileRoutingModule,
    BrowserModule,
    ImageCropperModule
  ],
  exports:[
    DetailsComponent,
    YourWallComponent
  ],
  bootstrap: [ProfileComponent],
  providers: [ ProfileService ]
})
export class ProfileModule { }
