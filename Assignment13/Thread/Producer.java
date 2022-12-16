/**
 * @author YXH_XianYu
 * Created On 2022-06-09
 */
public class Producer implements Runnable {
    @Override
    public void run() {
        synchronized (MyStack.getInstance()) {
            for(int i = 1; i <= 26; i++) {
                if(MyStack.getInstance().size() >= 5) {
                    try {
                        MyStack.getInstance().wait();
                    } catch (InterruptedException e) {System.out.println("Exception: " + e);}
                }

                MyStack.getInstance().push((char) (i + 'a' - 1));
                System.out.println("入栈: " + (char) (i + 'a' - 1));
                MyStack.getInstance().notifyAll(); // 唤醒Consumer（栈空）
            }
        }
    }
}
