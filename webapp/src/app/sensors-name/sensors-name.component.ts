import {Component, OnInit} from '@angular/core';
import {SensorService} from "../sensors.service";

@Component({
  selector: 'app-sensors-name',
  templateUrl: './sensors-name.component.html',
  styleUrls: ['./sensors-name.component.css']
})
export class SensorsNameComponent implements OnInit {
  names: Array<String>;

  constructor(private sensorService: SensorService) {
  }

  ngOnInit(): void {
    this.getNames();
  }

  getNames() {
    this.sensorService.getSensorNames().subscribe(dto => this.names = dto);
  }
}
