import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard.component';

const routes: Routes = [
  // {path: "", redirectTo: 'friends/friends', pathMatch: 'full'},
  { path: "dashboard", redirectTo: 'dashboard/dashboard', pathMatch: 'full' },
  { path: "dashboard/dashboard", component: DashboardComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
