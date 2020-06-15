export class Sensor {
  id: number;
  name: string;
  measurement: number;
  time: number;
}

export class Sensors {
  sensors: Array<Sensor>;
}
