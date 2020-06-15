package ro.ubb.razvan.monitorweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.razvan.monitorcore.model.Sensor;
import ro.ubb.razvan.monitorcore.service.SensorService;
import ro.ubb.razvan.monitorweb.converter.SensorConverter;
import ro.ubb.razvan.monitorweb.dto.SensorsDTO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

@RestController
public class SensorRestController {
    public static final int PORT = 2000;
    public static final String HOST = "localhost";

    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorConverter sensorConverter;

    @GetMapping(value = "/all")
    public SensorsDTO getAll() {
        List<Sensor> all = sensorService.findAll();
        return new SensorsDTO(sensorConverter.toDTOList(all));
    }

    @GetMapping(value = "/sensors")
    public List<String> getAllNames() {
        return sensorService.findAllSensorNames();
    }

    @GetMapping(value = "/sensors/{name}")
    public SensorsDTO getAllByName(@PathVariable String name) {
        List<Sensor> all = sensorService.findAllByName(name);
        return new SensorsDTO(sensorConverter.toDTOList(all));
    }

    @PostMapping(value = "/kill")
    public void kill(@RequestParam String name) {
        System.out.println("i wanna kill " + name);
        try (Socket socket = new Socket(HOST, PORT);
             InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
        ) {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("kill;" + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
