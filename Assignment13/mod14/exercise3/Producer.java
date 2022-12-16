/**
 * @author YXH_XianYu
 * Created On 2022-06-08
 */
public class Producer implements Runnable{
    private int sizeOfJobs;
    private int numberOfJobs;
    private int delayBetweenJobs;
    private String producerName;

    public Producer(int sizeOfJobs, int numberOfJobs, int delayBetweenJobs, String producerName) {
        this.sizeOfJobs = sizeOfJobs;
        this.numberOfJobs = numberOfJobs;
        this.delayBetweenJobs = delayBetweenJobs;
        this.producerName = producerName;
    }

    @Override
    public void run() {
        PrintJob job;
        for(int i = 1; i <= numberOfJobs; i++) {
            // set job
            job = new PrintJob(producerName + " # " + i, sizeOfJobs);
            // add job
            Printer.getInstance().addJob(job);
            // sleep
            try {
                Thread.sleep(delayBetweenJobs * 1000);
            } catch (InterruptedException e) {
                System.out.println("Exception: " + e);
            }
        }
    }
}
