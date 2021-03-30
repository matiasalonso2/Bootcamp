package JavaClase3TM;

public class Triangulo extends FiguraGeometrica{

    private double b;
    private double h;

    public Triangulo(double b, double h) {
        this.b = b;
        this.h = h;
    }


    @Override
    public double area() {
        return (b*h)/2;
    }
}
