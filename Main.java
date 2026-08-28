
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