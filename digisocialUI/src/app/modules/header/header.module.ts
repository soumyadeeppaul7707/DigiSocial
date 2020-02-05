import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { MenubarComponent } from './menubar/menubar.component';

@NgModule({
  declarations: [NavbarComponent, MenubarComponent],
  imports: [
    CommonModule
  ],
  exports:[
    MenubarComponent,
    NavbarComponent
  ]
})
export class HeaderModule { }
