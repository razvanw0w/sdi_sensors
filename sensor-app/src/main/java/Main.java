import ro.ubb.razvan.sensorapp.validation.SensorInfoValidator;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int PORT = 2000;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        String name = null;
        int id = 0, lower = 0, upper = 0;
        SensorInfoValidator validator = new SensorInfoValidator();
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        while (!valid) {
            System.out.print("name: ");
            name = scanner.next();
            System.out.print("id: ");
            id = scanner.nextInt();
            System.out.print("lower: ");
            lower = scanner.nextInt();
            System.out.print("upper: ");
            upper = scanner.nextInt();

            try {
                validator.validate(id, name, lower, upper);
                valid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (running) {
            try (Socket socket = new Socket(HOST, PORT);
                 InputStream inputStream = socket.getInputStream();
                 OutputStream outputStream = socket.getOutputStream();
            ) {
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                float measurement = lower + random.nextFloat() * (upper - lower);
                System.out.println("sending " + name + ";" + String.valueOf(id) + ";" + String.valueOf(measurement));
                dataOutputStream.writeUTF("info;" + name + ";" + String.valueOf(id) + ";" + String.valueOf(measurement));
                Thread.sleep(1000 + random.nextInt(2000));
                if (dataInputStream.available() > 0) {
                    running = false;
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " died!");
    }
}
