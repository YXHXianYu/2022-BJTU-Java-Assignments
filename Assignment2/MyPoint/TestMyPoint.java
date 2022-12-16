/**
 * @author YXH_XianYu
 * @create 2022-03-15
 */

/**
 * Test Class
 */
public class TestMyPoint {
    public static void main(String[] args) {

        MyPoint point1 = new MyPoint();
        System.out.println("MyPoint() Test: " + point1.toString());
        MyPoint point2 = new MyPoint(1, 2);
        System.out.println("MyPoint(1, 2) Test: " + point2.toString());
        System.out.println();

        point1.setX(1);
        point1.setY(3);
        System.out.println("setX(1) and setY(3) Test: " + point1.toString());
        System.out.println("getX() and getY() Test: " + point1.getX() + ", " + point1.getY());
        point1.setXY(0, 0);
        System.out.println("setXY(0, 0) Test: " + point1.toString());
        System.out.println("toString is tested.");
        System.out.println();

        System.out.println("distance(0, 1) Test: " + point1.distance(0, 1));
        point2.setXY(0, 2);
        System.out.println("distance(another) Test: " + point1.distance(point2));
        System.out.println("distance() Test: " + point1.distance());
    }
}
