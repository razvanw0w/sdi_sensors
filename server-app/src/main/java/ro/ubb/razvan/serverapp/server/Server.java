package ro.ubb.razvan.serverapp.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Server implements ApplicationContextAware {
    public static final int PORT = 2000;
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                HandleMeasurement task = context.getBean(HandleMeasurement.class);
                task.setClientSocket(socket);
                executorService.submit(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
