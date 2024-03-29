package ro.ubb.razvan.monitorweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan({"ro.ubb.razvan.monitorweb.controller", "ro.ubb.razvan.monitorweb.converter"})
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200", "http://localhost:8080")
                        .allowedMethods("GET", "PUT", "POST", "DELETE")
                        .exposedHeaders("Access-Control-Allow-Origin:*")
                        .exposedHeaders("Access-Control-Allow-Headers:*")
                        .exposedHeaders("Access-Control-Allow-Methods>:*")
                        .allowCredentials(true)
                        .allowedHeaders("Content-Type");
            }
        };
    }
}
