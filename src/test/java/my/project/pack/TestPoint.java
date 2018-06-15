package my.project.pack;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestPoint {

    @Test
    public void checkdistanceto (){
        Point p1 = new Point(2.0,3.0);
        Point p2 = new Point(4.0,3.0);
        Assert.assertEquals(p1.distanceto(p2),2.0,"Ошибка");
    }

    @Test
    public void checkdistance (){
        Point p1 = new Point(2.0,3.0);
        Point p2 = new Point(4.0,3.0);
        Assert.assertEquals(MyFistProgram.distance(p2,p1),2.0,"Ошибка");
    }

    @Test
    public void failCheckdistance (){
        Point p1 = new Point(1.0,3.8);
        Point p2 = new Point(4.1,3.0);
        Assert.assertNotEquals(MyFistProgram.distance(p2,p1),2.0,"Ошибка");
    }

    @Test
    public void checkNullResult (){
        Point p1 = new Point();
        Point p2 = new Point();
        Assert.assertEquals(MyFistProgram.distance(p2,p1),0.0,"Ошибка");
    }

}
