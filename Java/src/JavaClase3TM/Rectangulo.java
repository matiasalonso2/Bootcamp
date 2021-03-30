package JavaClase3TM;

public class Rectangulo extends FiguraGeometrica{

    private double b;
    private double h;

    public Rectangulo(double b, double h) {
        this.b = b;
        this.h = h;
    }


    @Override
    public double area() {
        return b*h;
    }
}
