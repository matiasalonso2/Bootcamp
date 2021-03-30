package JavaClase4Repaso.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int AnguloDeGiro, String patente) throws Exception {
        if (listaDeVehiculos.size() == cantidadDeVehiculosPermitidos)
            throw new Exception();
        listaDeVehiculos.add(new Auto(velocidad, aceleracion, AnguloDeGiro, patente));

    };
    public void darDeAltaMoto(int velocidad, int aceleracion, int AnguloDeGiro, String patente) throws Exception{
        if (listaDeVehiculos.size() == cantidadDeVehiculosPermitidos)
            throw new Exception();
        listaDeVehiculos.add(new Moto(velocidad, aceleracion, AnguloDeGiro, patente));
    };

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    };

    public void eliminarVehiculoConPatente(String unaPatente){

    };

    public Vehiculo ganador(){
        Vehiculo ganador = null;
        long max = 0;
        for(Vehiculo v: listaDeVehiculos){
            long pts = (long) ((v.getAceleracion() * 0.5 * v.getAceleracion()) / (v.getAnguloDeGiro() * (v.getPeso()- v.getRuedas() * 100)));
            if (pts>max) {
                max = pts;
                ganador = v;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente){
        for (Vehiculo v: listaDeVehiculos)
            if (v.getPatente().equals(patente))
                socorristaAuto.socorrer((Auto) v);
    };

    public void socorrerMoto(String patente){
        for (Vehiculo v: listaDeVehiculos)
            if (v.getPatente().equals(patente))
                socorristaMoto.socorrer((Moto) v);
    };

}
