package ro.ubb.razvan.monitorweb.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
public class SensorsDTO implements Serializable {
    private List<SensorDTO> sensors;
}
