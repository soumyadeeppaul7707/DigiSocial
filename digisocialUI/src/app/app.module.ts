import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './modules/header/header.module';
import { AuthenticationModule } from './modules/authentication/authentication.module';
import { FooterModule } from './modules/footer/footer.module';
import { RecentsModule } from './modules/body/recents/recents.module';
import { FriendandchatModule } from './modules/body/friendandchat/friendandchat.module';
import { ProfileModule } from './modules/body/profile/profile.module';
import { HttpClientModule } from '@angular/common/http';
import { DashboardModule } from './modules/body/dashboard/dashboard.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthenticationModule,
    HttpClientModule,
    HeaderModule,
    FooterModule,
    RecentsModule,
    FriendandchatModule,
    ProfileModule,
    DashboardModule
  ],
  exports: [],
  providers: [
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
