/**
 * @author YXH_XianYu
 * Created On 2022-06-09
 */
public class MyStack {
    private static MyStack instance;
    private MyStack() {
    }
    public static MyStack getInstance() {
        // 这里遇到了一个问题，单例模式在多线程中可能会同时出现多个不同的对象，导致出现illegalMonitorStateException。
        // 查阅资料后，得知，需要修改getInstance方法，使得该方法线程安全（即可以同时被多个线程调用）。
        // 参考：http://t.zoukankan.com/meet-p-5290948.html

        if(instance == null) {
            synchronized (MyStack.class) { // 保证同一时间，只有一个线程初始化单例模式
                if(instance == null)
                    instance = new MyStack();
            }
        }
        return instance;
    }

    private int top = 0;
    private char[] array = new char[10];
    private int maxSize = 5;

    public void push(char c) {
        if(top >= maxSize) return; // 如果已经存满了，那么就直接return
        array[++top] = c;
    }

    public char pop() {
        if(top <= 0) return 0;
        return array[top--];
    }

    public int size() {
        return top;
    }
}
