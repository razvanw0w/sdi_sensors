import {Component, OnInit} from '@angular/core';
import {Sensor} from "../sensors.model";
import {SensorService} from "../sensors.service";

@Component({
  selector: 'app-sensors-all',
  templateUrl: './sensors-all.component.html',
  styleUrls: ['./sensors-all.component.css']
})
export class SensorsAllComponent implements OnInit {
  sensors: Array<Sensor>;

  constructor(private sensorService: SensorService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.sensorService.getSensors().subscribe(dto => this.sensors = dto.sensors);
  }
}
