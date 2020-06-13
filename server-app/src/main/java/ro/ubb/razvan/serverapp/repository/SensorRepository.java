package ro.ubb.razvan.serverapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.razvan.serverapp.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
