import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { MenubarComponent } from './menubar/menubar.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [NavbarComponent, MenubarComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    MenubarComponent,
    NavbarComponent
  ]
})
export class HeaderModule { }
