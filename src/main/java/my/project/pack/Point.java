package my.project.pack;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }
//    @Override
//    public String toString() {
//        return "x= "+x+" y= "+y;
//    }

    public double distanceto(Point p1) {
        return Math.sqrt(Math.pow((this.x - p1.x), 2) + Math.pow((this.y - p1.y), 2));

    }
}
