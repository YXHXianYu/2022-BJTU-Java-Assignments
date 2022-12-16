/**
 * @author YXH_XianYu
 * Created On 2022-06-08
 */

public class Printer implements Runnable {
    // Singleton
    private static Printer instance;
    private Printer() {
        printQueue = new CircularQueue(10); // >= 5
        stateIsRunning = true;
    }
    public static Printer getInstance() {
        if(instance == null) {
            synchronized (Printer.class) { // 线程安全
                if(instance == null)
                    instance = new Printer();
            }
        }
        return instance;
    }
    
    private Queue printQueue;
    private boolean stateIsRunning;
    
    public synchronized void addJob(PrintJob job) {
        // 因为有多个线程调用此方法，所以需要使用while
        while (printQueue.getSize() >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e);
            }
        }
        printQueue.addBack(job);
        notifyAll();
        System.out.println("P: Adding job \'" + job.getName() + "\' to the queue");
    }

    private synchronized PrintJob getJob() {
        // 因为只有一个线程调用此方法，所以不用while
        if(printQueue.isEmpty()) {
            try {
                System.out.println("  C: Waiting on a job to print.");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e);
            }
        }
        PrintJob job = (PrintJob) printQueue.getFront();
        printQueue.removeFront();
        notifyAll();
        return job;
    }

    public synchronized void halt() {
        stateIsRunning = false;
    }

    public void run() {
        System.out.println("  C: Print manager is starting up.");
        // 若 三个进程全部结束 且 printer在等待，则 停止进程。
        while(stateIsRunning || !printQueue.isEmpty()) {
            PrintJob job;
            // get job
            job = getJob();
            // start job
            System.out.println("  C: Starting job \'" + job.getName() + "\'");
            for(int i = 1; i <= job.getPages(); i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Exception: " + e);
                }
            }
            System.out.println("  C: Completed job \'" + job.getName() + "\'");
        }
        System.out.println("  C: Print manager is halted.");
    }
}
