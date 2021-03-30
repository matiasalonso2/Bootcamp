package JavaClase3TM;

public class Main {

    public static void main(String[] args)
    {
       FiguraGeometrica[] arr = {new Circulo(3.2), new Triangulo(2.4,3), new Rectangulo(1,2)};

       System.out.println(ClaseUtilitaria.areaPromedio(arr));
    }

}