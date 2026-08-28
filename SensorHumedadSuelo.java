
public class SensorHumedadSuelo extends Sensor {
    
    private double humedad;

    public SensorHumedadSuelo(String id, String ubicacion, boolean activo) {
        super(id, ubicacion, activo); //referencia a la clase padre, llama al constructor de Sensor
    }

    @Override //sobreescribir el metodo heredado
    public double tomarLectura() {
        this.humedad = Math.random() * 100;
        return this.humedad;
    }
    @Override
    public String evaluarEstado() {
        return (humedad < 20) ? "estado critico" : "normal"; //operador ternario
    }
}
