package ro.ubb.razvan.serverapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ro.ubb.razvan.serverapp.server.HandleMeasurement;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public HandleMeasurement handleMeasurement() {
        return new HandleMeasurement();
    }
}
