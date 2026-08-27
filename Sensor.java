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

class SensorTemperatura extends Sensor {
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

class EstacionMonitoreo{

    List<Sensor> sensores = new ArrayList<>();

    public void registrarSensor(Sensor sensor) {
        this.sensores.add(sensor);
    }

    public void procesarLecturas(){
        
        for (Sensor sensor : sensores) {
            double lectura = sensor.tomarLectura();
            String estado = sensor.evaluarEstado();
            System.out.println("Sensor ID: " + sensor.getId() + ", Ubicación: " + sensor.getUbicacion() + ", Lectura: " + lectura + ", Estado: " + estado);
        }
    }

    public void filtroSensores(){
         for (Sensor sensor : sensores) {
            double lectura = sensor.tomarLectura();
            String estado = sensor.evaluarEstado();

            if (estado.equals("estado critico")) {
                System.out.println("ALERTA: Sensor ID: " + sensor.getId() + " en estado critico. Ubicación: " + sensor.getUbicacion() + ", Lectura: " + lectura); 
            }
    }
}
}


 class Main {
    public static void main(String[] args) {
        // 1. Crear la estación
        EstacionMonitoreo estacion = new EstacionMonitoreo();

        // 2. Registrar sensores
        estacion.registrarSensor(new SensorTemperatura("TEMP-01", "Invernadero A", true));
        estacion.registrarSensor(new SensorTemperatura("TEMP-02", "Caldera Norte", true));
        estacion.registrarSensor(new SensorHumedadSuelo("HUM-01", "Cultivo Sur", true));
        estacion.registrarSensor(new SensorHumedadSuelo("HUM-02", "Jardín Este", true));

        // 3. Generar las lecturas de todos los sensores
        System.out.println("=== TOMANDO LECTURAS DE LA ESTACIÓN ===");
        estacion.procesarLecturas();

        // 4. Filtrar y mostrar los que quedaron en estado crítico
        System.out.println("\n=== REPORTANDO SENSORES EN ESTADO CRÍTICO ===");
        estacion.filtroSensores();
    }
}