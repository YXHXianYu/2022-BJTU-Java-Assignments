/**
 * @author YXH_XianYu
 * Created On 2022-06-09
 */
public class TestThread {
    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(), "Thread-Producer");
        Thread consumer = new Thread(new Consumer(), "Thread-Consumer");
        producer.start();
        consumer.start();
    }
}
