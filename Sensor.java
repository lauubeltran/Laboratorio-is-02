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