import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthenticationRoutingModule } from './modules/authentication/authentication-routing.module';

const routes: Routes = [
   {path:'authentication',loadChildren: './modules/authentication/authentication.module#AuthenticationModule'},
   {path:'', redirectTo: 'authentication', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes), AuthenticationRoutingModule ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
