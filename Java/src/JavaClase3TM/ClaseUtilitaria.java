package JavaClase3TM;

public class ClaseUtilitaria {

    public static double areaPromedio(FiguraGeometrica arr[]){
        double acumulador = 0;
        for (FiguraGeometrica fig: arr) {
            acumulador += fig.area();
        }
        return acumulador/arr.length;
    }

}
