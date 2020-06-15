import {Component, OnInit} from '@angular/core';
import {SensorService} from "../sensors.service";
import {Sensor} from "../sensors.model";

@Component({
  selector: 'app-sensors-name',
  templateUrl: './sensors-name.component.html',
  styleUrls: ['./sensors-name.component.css']
})
export class SensorsNameComponent implements OnInit {
  names: Array<String>;
  shown = false;
  dataForNames = new Map<String, Array<Sensor>>();

  constructor(private sensorService: SensorService) {
  }

  ngOnInit(): void {
    this.getNames();
  }

  getNames() {
    this.sensorService.getSensorNames().subscribe(dto => this.names = dto);
  }

  showClicked() {
    this.shown = true;
    this.updateData();
    setInterval(() => this.updateData(), 3000);
  }

  updateData() {
    this.getNames();
    this.names.forEach(name => {
      this.sensorService.getSensorsByName(name)
        .subscribe(dto => {
          this.dataForNames.set(name, dto.sensors);
          console.log(dto.sensors);
        });
    });
  }
}
