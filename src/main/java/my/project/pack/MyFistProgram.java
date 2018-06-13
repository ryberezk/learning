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
    }
}