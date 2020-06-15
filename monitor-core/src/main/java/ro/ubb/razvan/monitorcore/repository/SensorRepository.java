package ro.ubb.razvan.monitorcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.razvan.monitorcore.model.Sensor;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    @Query("select distinct sensor.name from Sensor sensor")
    List<String> findAllNames();
}
