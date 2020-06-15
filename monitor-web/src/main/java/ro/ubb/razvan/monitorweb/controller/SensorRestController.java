package ro.ubb.razvan.monitorweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.ubb.razvan.monitorcore.model.Sensor;
import ro.ubb.razvan.monitorcore.service.SensorService;
import ro.ubb.razvan.monitorweb.converter.SensorConverter;
import ro.ubb.razvan.monitorweb.dto.SensorsDTO;

import java.util.List;

@RestController
public class SensorRestController {
    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorConverter sensorConverter;

    @GetMapping(value = "/all")
    public SensorsDTO getAll() {
        List<Sensor> all = sensorService.findAll();
        return new SensorsDTO(sensorConverter.toDTOList(all));
    }
}
