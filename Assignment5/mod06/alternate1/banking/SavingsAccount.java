package banking;

/**
 * @author YXH_XianYu
 * @create 2022-04-02
 */
public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    
}
