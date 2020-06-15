package ro.ubb.razvan.monitorweb.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Builder
public class SensorDTO implements Serializable {
    private Long id;
    private String name;
    private Float measurement;
    private Long time;
}
