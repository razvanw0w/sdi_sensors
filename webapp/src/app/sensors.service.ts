import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Sensors} from "./sensors.model";
import {Observable} from "rxjs";

@Injectable()
export class SensorService {
  private url = "http://localhost:8080/api";

  constructor(private httpClient: HttpClient) {
  }

  getSensors(): Observable<Sensors> {
    return this.httpClient.get<Sensors>(`${this.url}/all`);
  }

  getSensorNames(): Observable<Array<String>> {
    return this.httpClient.get<Array<String>>(`${this.url}/sensors`);
  }

  getSensorsByName(name: String): Observable<Sensors> {
    return this.httpClient.get<Sensors>(`${this.url}/sensors/${name}`);
  }

  killSensor(name: string): Observable<any> {
    console.log(`${this.url}/kill`)
    return this.httpClient.post(`${this.url}/kill?name=${name}`, {});
  }
}
