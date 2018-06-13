package my.project.pack;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x= "+x+" y= "+y;
    }

    public double distanceto (Point p1){
        return  Math.sqrt(Math.pow((p1.x - this.x), 2)+Math.pow((p1.y - this.y), 2));

    }
}
