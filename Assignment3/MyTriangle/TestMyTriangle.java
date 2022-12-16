/**
 * @author YXH_XianYu
 * @create 2022-03-21
 */
public class TestMyTriangle {
    public static void main(String[] args) {

        MyTriangle t1 = new MyTriangle(0, 0, 1, 0, 0, 1);
        System.out.println("MyTriangle1: " + t1);

        MyTriangle t2 = new MyTriangle(new MyPoint(0, 0), new MyPoint(2, 0), new MyPoint(0, 1));
        System.out.println("MyTriangle2: " + t2);

        System.out.println("t1.toString(): " + t1.toString());

        System.out.println("t1.getPerimeter(): " + t1.getPerimeter());

        System.out.println("t1.getType(): " + t1.getType());
        System.out.println("t2.getType(): " + t2.getType());
    }
}
