package ro.ubb.razvan.serverapp.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ro.ubb.razvan.serverapp.model.Sensor;
import ro.ubb.razvan.serverapp.repository.SensorRepository;

import java.io.*;
import java.net.Socket;

@Service
@Scope("prototype")
public class HandleMeasurement implements Runnable {
    private Socket clientSocket = null;

    @Autowired
    private SensorRepository sensorRepository;

    public HandleMeasurement(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public HandleMeasurement() {
    }

    public void setClientSocket(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            System.out.println(Server.toKill);
            String measurement = dataInputStream.readUTF();
            String[] split = measurement.split(";");
            String name = split[1];
            if (split[0].equals("info")) {
                if (Server.toKill.contains(name)) {
                    Server.toKill.remove(name);
                    dataOutputStream.writeUTF("die");
                } else {
                    int id = Integer.parseInt(split[2]);
                    float value = Float.parseFloat(split[3]);
                    System.out.println("sensor-name: " + name + " sensor-id: " + id + " measurement: " + value);
                    Sensor sensor = Sensor.builder()
                            .name(name)
                            .sensorId(id)
                            .measurement(value)
                            .time(System.currentTimeMillis())
                            .build();
                    sensorRepository.save(sensor);
                }
            } else {
                System.out.println("someone wants " + name + " dead :(");
                Server.toKill.add(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
