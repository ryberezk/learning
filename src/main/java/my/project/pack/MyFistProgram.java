package my.project.pack;

public class MyFistProgram {

    public static void main(String[] args) {

        System.out.println("Hello, world");

        Square sq = new Square();
        sq.x = 15.0;
        sq.color = "Синий";

        Triangle t = new Triangle();
        t.a = 15;
        t.b = 20;

        t.area();
        System.out.println(t);
        Point point3 = new Point(1.2,1.6);
        Point point4 = new Point(1.9,1.8);
        Point point1 = new Point(2.9,1.2);
        Point point2 = new Point(6.9,3.4);
        System.out.println("Расстояние от точки "+point4+" до точки " +point1 + " равно "+point1.distanceto(point4));
        System.out.println("Расстояние равно: " + distance(point3,point4));

    }

    public static double distance (Point p1, Point p2){
        return Math.sqrt(Math.pow((p2.x - p1.x), 2)+Math.pow((p2.y - p2.y), 2));
    }

}