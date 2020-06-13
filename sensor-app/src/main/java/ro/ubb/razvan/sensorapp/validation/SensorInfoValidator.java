package ro.ubb.razvan.sensorapp.validation;

public class SensorInfoValidator {
    public void validate(int id, String name, int lower, int upper) throws Exception {
        StringBuilder errorBuilder = new StringBuilder();
        if (id <= 1023) {
            errorBuilder.append("id smaller or equal than 1023\n");
        }
        if (lower >= upper) {
            errorBuilder.append("lower >= upper\n");
        }
        if (errorBuilder.length() > 0) {
            throw new Exception(errorBuilder.toString());
        }
    }
}
