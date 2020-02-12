import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DetailsComponent } from './details/details.component';
import { YourWallComponent } from './your-wall/your-wall.component';
import { ProfileRoutingModule } from './profile-routing.module';
import { BrowserModule } from '@angular/platform-browser';
import { ProfileComponent } from './profile.component';

@NgModule({
  declarations: [DetailsComponent, YourWallComponent, ProfileComponent],
  imports: [
    CommonModule,
    ProfileRoutingModule,
    BrowserModule
  ],
  exports:[
    DetailsComponent,
    YourWallComponent
  ],
  bootstrap: [ProfileComponent]
})
export class ProfileModule { }
