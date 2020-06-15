import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SensorsAllComponent} from './sensors-all/sensors-all.component';
import {SensorService} from "./sensors.service";
import {HttpClientModule} from "@angular/common/http";
import {SensorsNameComponent} from './sensors-name/sensors-name.component';

@NgModule({
  declarations: [
    AppComponent,
    SensorsAllComponent,
    SensorsNameComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SensorService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
