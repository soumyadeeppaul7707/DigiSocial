import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderModule } from './modules/header/header.module';
import { AuthenticationModule } from './modules/authentication/authentication.module';
import { FooterModule } from './modules/footer/footer.module';
import { RecentsModule } from './modules/body/recents/recents.module';
import { FriendsModule } from './modules/body/friends/friends.module';
import { ProfileModule } from './modules/body/profile/profile.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AuthenticationModule,
    HeaderModule,
    FooterModule,
    RecentsModule,
    FriendsModule,
    ProfileModule
  ],
  exports:[],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
