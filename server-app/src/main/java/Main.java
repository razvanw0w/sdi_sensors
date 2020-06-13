import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.razvan.serverapp.server.Server;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "ro.ubb.razvan.serverapp.config"
        );
        Server server = context.getBean(Server.class);
        server.run();
    }
}
