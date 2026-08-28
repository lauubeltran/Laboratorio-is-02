import java.util.Random;

public class SensorTemperatura extends Sensor {
    private double celsius;
    private final Random random = new Random();

    public SensorTemperatura(String id, String ubicacion, boolean activo) {
        super(id, ubicacion, activo); // Llama al constructor de Sensor
    }

    @Override
    public double tomarLectura() {
        this.celsius = 15 + random.nextDouble() * 30;
        return this.celsius;
    }

    @Override
    public String evaluarEstado() {
        return (celsius > 38) ? "estado critico" : "normal";
    }

}