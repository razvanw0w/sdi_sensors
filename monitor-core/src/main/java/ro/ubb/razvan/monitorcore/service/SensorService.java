package ro.ubb.razvan.monitorcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.razvan.monitorcore.model.Sensor;
import ro.ubb.razvan.monitorcore.repository.SensorRepository;

import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    public List<String> findAllSensorNames() {
        return sensorRepository.findAllNames();
    }

    public List<Sensor> findAllByName(String name) {
        return sensorRepository.findTop4ByNameOrderByTimeDesc(name);
    }

    public void killSensor(String name) {

    }
}
