package ro.ubb.razvan.monitorcore.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private int sensorId;

    @Column(name = "sensor_name")
    private String name;

    private Float measurement;

    private Long time;
}
