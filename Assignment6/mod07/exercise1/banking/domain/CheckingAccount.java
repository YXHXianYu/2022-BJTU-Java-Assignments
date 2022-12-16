package banking.domain;

/**
 * @author YXH_XianYu
 */
public class CheckingAccount extends Account {
    private double overdraftProtection;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double protect) {
        super(balance);
        this.overdraftProtection = protect;
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            return true;
        } else {
            if(amount <= balance + overdraftProtection) {
                amount -= balance;
                balance = 0;
                overdraftProtection -= amount;
                return true;
            } else {
                return false;
            }
        }
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }
}
