import java.util.ArrayList;
import java.util.List;
public class EstacionMonitoreo{

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