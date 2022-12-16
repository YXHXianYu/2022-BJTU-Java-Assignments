/**
 * @author YXH_XianYu
 * @create 2022-03-15
 */

/**
 * 管理一个二维点对的类
 */
public class MyPoint {
    /**
     * 私有的x值
     */
    private int x;

    /**
     * 私有的y值
     */
    private int y;

    /**
     * 初始值为(0, 0)的构造方法
     */
    public MyPoint() {
        this.x = 0; this.y = 0;
    }

    /**
     * 初始值为(x, y)的构造方法
     * @param x x值
     * @param y y值
     */
    public MyPoint(int x, int y) {
        this.x = x; this.y = y;
    }

    /**
     * 获取x值
     * @return x值
     */
    public int getX() {
        return x;
    }

    /**
     * 设置x值
     * @param x 将要设置的x值
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取y值
     * @return y值
     */
    public int getY() {
        return y;
    }

    /**
     * 设置y值
     * @param y 将要设置的y值
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 设置x值和y值
     * @param x 将要设置的x值
     * @param y 将要设置的y值
     */
    public void setXY(int x, int y) {
        this.x = x; this.y = y;
    }

    /**
     * 返回 "(x,y)"
     * @return "(x,y)"
     */
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * 给出一个点(x, y)，返回已知点和该点的距离
     * @param x 给出点的x值
     * @param y 给出点的y值
     * @return 已知点和该点的距离
     */
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(x - this.x, 2.0) + Math.pow(y - this.y, 2.0));
    }

    /**
     * 给出一个点another，返回已知点和该点的距离
     * @param another 一个类型为MyPoint的另一个点
     * @return 已知点和该点的距离
     */
    public double distance(MyPoint another) {
        return Math.sqrt(Math.pow(x - another.x, 2.0) + Math.pow(y - another.y, 2.0));
    }

    /**
     * 返回已知点和(0, 0)的距离
     * @return 已知点和(0, 0)的距离
     */
    public double distance() {
        return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0));
    }
}
