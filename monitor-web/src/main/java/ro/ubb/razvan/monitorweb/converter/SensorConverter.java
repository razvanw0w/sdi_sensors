package ro.ubb.razvan.monitorweb.converter;

import org.springframework.stereotype.Component;
import ro.ubb.razvan.monitorcore.model.Sensor;
import ro.ubb.razvan.monitorweb.dto.SensorDTO;

@Component
public class SensorConverter implements Converter<Sensor, SensorDTO> {
    @Override
    public Sensor toModel(SensorDTO sensorDTO) {
        return Sensor.builder()
                .id(sensorDTO.getId())
                .name(sensorDTO.getName())
                .measurement(sensorDTO.getMeasurement())
                .time(sensorDTO.getTime())
                .build();
    }

    @Override
    public SensorDTO toDTO(Sensor sensor) {
        return SensorDTO.builder()
                .id(sensor.getId())
                .name(sensor.getName())
                .measurement(sensor.getMeasurement())
                .time(sensor.getTime())
                .build();
    }
}
