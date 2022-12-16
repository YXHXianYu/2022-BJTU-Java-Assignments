/**
 * @author YXH_XianYu
 * Created On 2022-06-08
 */
public class TestPrinter {
    public static void main(String[] args) {
        Producer[] producers = new Producer[6];

        producers[1] = new Producer(5, 3, 2, "Kisaragi Tomi");
        producers[2] = new Producer(15, 2, 5, "Ogata Nenji");
        producers[3] = new Producer(25, 2, 10, "Shinonome Ryōko");

        Thread printerThread = new Thread(Printer.getInstance());
        printerThread.start();

        Thread[] threads = new Thread[6];
        for(int i = 1; i <= 3; i++) {
            threads[i] = new Thread(producers[i]);
            threads[i].start();
        }

        try {
            threads[1].join();
            threads[2].join();
            threads[3].join();
            Printer.getInstance().halt(); // 若 三个进程全部结束 且 printer在等待，则 停止进程。
            printerThread.join();
        } catch (InterruptedException e) {
            System.out.println("Exception: " + e);
        }
    }
}
