import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SensorsAllComponent} from "./sensors-all/sensors-all.component";


const routes: Routes = [
  {path: 'all', component: SensorsAllComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
