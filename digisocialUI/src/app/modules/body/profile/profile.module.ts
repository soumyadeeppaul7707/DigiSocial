import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DetailsComponent } from './details/details.component';
import { YourWallComponent } from './your-wall/your-wall.component';

@NgModule({
  declarations: [DetailsComponent, YourWallComponent],
  imports: [
    CommonModule
  ]
})
export class ProfileModule { }
