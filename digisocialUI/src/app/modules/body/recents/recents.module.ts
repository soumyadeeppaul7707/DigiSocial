import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublicWallComponent } from './public-wall/public-wall.component';
import { RecentsRoutingModule } from './recents-routing.module';

@NgModule({
  declarations: [PublicWallComponent],
  imports: [
    CommonModule,
    RecentsRoutingModule
  ],
  exports: [
    PublicWallComponent
  ]
})
export class RecentsModule { }
