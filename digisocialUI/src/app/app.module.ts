import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './modules/header/header.module';
import { AuthenticationModule } from './modules/authentication/authentication.module';
import { FooterModule } from './modules/footer/footer.module';
import { NavbarComponent } from './modules/header/navbar/navbar.component';
import { MenubarComponent } from './modules/header/menubar/menubar.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthenticationModule,
    HeaderModule,
    FooterModule
  ],
  exports:[],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
