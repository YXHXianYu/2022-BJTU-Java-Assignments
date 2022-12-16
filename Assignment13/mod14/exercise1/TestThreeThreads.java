/**
 * @author YXH_XianYu
 * Created On 2022-06-08
 */
public class TestThreeThreads {
    public static void main(String[] args) {
        // 1. create an instance of PrintMe
        PrintMe printMe = new PrintMe();

        // 2. Create three threads using the PrintMe object
        Thread[] threads = {
                new Thread(printMe),
                new Thread(printMe),
                new Thread(printMe),
        };

        // 3. Name each thread using the setName method
        for(int i = 0; i <= 2; i++)
            threads[i].setName("Thread " + i);

        // 4. Start each thread
        for(int i = 0; i <= 2; i++)
            threads[i].start();
    }
}
