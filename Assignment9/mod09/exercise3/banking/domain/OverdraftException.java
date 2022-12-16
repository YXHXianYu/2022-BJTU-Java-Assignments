package banking.domain;

/**
 * @author YXH_XianYu
 * Created On 2022-04-28
 */
public class OverdraftException extends Exception {
    private double deficit;

    public OverdraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
