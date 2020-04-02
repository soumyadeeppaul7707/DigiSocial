import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { FriendrequestsreceivedComponent } from './friendrequestsreceived/friendrequestsreceived.component';
import { SearchfriendsComponent } from './searchfriends/searchfriends.component';

@NgModule({
  declarations: [DashboardComponent, FriendrequestsreceivedComponent, SearchfriendsComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ],
  exports: [DashboardComponent, FriendrequestsreceivedComponent, SearchfriendsComponent]
})
export class DashboardModule { }
