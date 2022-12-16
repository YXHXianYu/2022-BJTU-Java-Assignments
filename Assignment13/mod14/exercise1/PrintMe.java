/**
 * @author YXH_XianYu
 * Created On 2022-06-08
 */
public class PrintMe implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // sleep for 2 seconds
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}
