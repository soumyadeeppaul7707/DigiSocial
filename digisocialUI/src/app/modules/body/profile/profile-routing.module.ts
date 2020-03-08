import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileComponent } from './profile.component';


const routes: Routes = [
  {path: "profile/profile",component: ProfileComponent},
  {path: "profile", redirectTo: 'profile/profile', pathMatch: 'full'}//,
  //{path: "", redirectTo: 'profile/profile', pathMatch: 'full'}
   
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule]
})
export class ProfileRoutingModule { }
