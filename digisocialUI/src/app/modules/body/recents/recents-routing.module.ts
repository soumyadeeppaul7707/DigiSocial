import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PublicWallComponent } from './public-wall/public-wall.component';

const routes: Routes = [
  // {path: "", redirectTo: 'recents/public-wall', pathMatch: 'full'},
  {path: "recents", redirectTo: 'recents/public-wall', pathMatch: 'full'},
  {path: "recents/public-wall",component: PublicWallComponent}  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RecentsRoutingModule { }
