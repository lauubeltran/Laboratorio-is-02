import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {

    private final String id;
    private String ubicacion;
    private boolean activo;
    
    public Sensor(String id, String ubicacion, boolean activo){
       if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El id del sensor no puede estar vacío");
        }
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicación del sensor no puede estar vacía");
        }
        this.id = id;
        this.ubicacion = ubicacion;
        this.activo = activo;
    }

    public String getId(){return id;}
    public String getUbicacion(){return ubicacion;}
    public boolean isActivo(){return activo;}

  public void setUbicacion(String ubicacion){
        if (ubicacion == null || ubicacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicación del sensor no puede ser nula o vacia");
        }
        this.ubicacion = ubicacion;
    }
    public void setActivo(boolean activo){
        
        if (!activo) {
            
            System.out.println("AVISO: Desactivando el sensor de seguridad " + this.id);
        }
        this.activo = activo;
    }



    public abstract double tomarLectura();
    public abstract String evaluarEstado();

}

class SensorHumedadSuelo extends Sensor {
    
    private double humedad;

    public SensorHumedadSuelo(String id, String ubicacion, boolean activo) {
        super(id, ubicacion, activo);
    }

    @Override
    public double tomarLectura() {
        this.humedad = Math.random() * 100;
        return this.humedad;
    }
    @Override
    public String evaluarEstado() {
        return (humedad < 20) ? "estado critico" : "normal";
    }
}

class SensorTemperatura extends Sensor {
    private double celsius;
    private final java.util.Random random = new java.util.Random();

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
