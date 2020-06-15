package ro.ubb.razvan.monitorcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ubb.razvan.monitorcore.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
