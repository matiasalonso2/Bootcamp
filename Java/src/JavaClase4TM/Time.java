package JavaClase4TM;

public class Time {
    private long tiempoInicio;
    private long tiempoFin;

    public void start(){
        this.tiempoInicio = System.currentTimeMillis();
    }
    public void stop(){
        this.tiempoFin = System.currentTimeMillis();
    }
    public long elapsedTime(){
        return tiempoFin - tiempoInicio;
    }
}