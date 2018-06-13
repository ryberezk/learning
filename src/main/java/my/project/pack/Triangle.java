package my.project.pack;

public class Triangle {
    public Triangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Triangle() {
    }

    public double a;
    public double b;

    @Override
    public String toString() {
        return "Площадь равна " + area();
    }

    public double area() {
        return ((a * b) / 2);
    }
}
