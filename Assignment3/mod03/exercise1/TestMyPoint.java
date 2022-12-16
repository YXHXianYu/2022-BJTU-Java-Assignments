/**
 * @author YXH_XianYu
 * @create 2022-03-21
 */
public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint start = new MyPoint();
        MyPoint end = new MyPoint();

        start.x = 10;
        start.y = 10;

        end.x = 20;
        end.y = 30;

        System.out.println("Start point is " + start);
        System.out.println("End point is " + end);
        System.out.println();

        MyPoint stray = end;
        System.out.println("Stray point is " + stray);
        System.out.println("End point is " + end);
        System.out.println();

        stray.x = 114;
        stray.y = 514;
        System.out.println("Stray point is " + stray);
        System.out.println("End point is " + end);
        System.out.println("Start point is " + start);
    }
}
