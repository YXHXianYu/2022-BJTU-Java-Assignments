/**
 * @author YXH_XianYu
 * Created On 2022-06-09
 */
public class Consumer implements Runnable {
    @Override
    public void run() {
        synchronized (MyStack.getInstance()) {
            for(int i = 1; i <= 26; i++) { // 因为已知需要处理26次，所以直接用for循环写
                if(MyStack.getInstance().size() == 0) {
                    try {
                        MyStack.getInstance().wait();
                    } catch (InterruptedException e) {System.out.println("Exception: " + e);}
                }

                System.out.println("出栈: " + MyStack.getInstance().pop());
                MyStack.getInstance().notifyAll(); // 唤醒Producer（栈满）
            }
        }
    }
}
