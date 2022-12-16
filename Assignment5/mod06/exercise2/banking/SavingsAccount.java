package banking;

/**
 * @author YXH_XianYu
 */
public class SavingsAccount extends Account {
    private double interestRate;
    
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
}
