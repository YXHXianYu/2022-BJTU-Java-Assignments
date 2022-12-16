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
    public void withdraw(double amount) throws OverdraftException {
        if(amount <= balance) {
            balance -= amount;
        } else {
            if(amount <= balance + overdraftProtection) {
                amount -= balance;
                balance = 0;
                overdraftProtection -= amount;
            } else {
                if(overdraftProtection == 0)
                    throw new OverdraftException("No overdraft protection", amount - balance);
                else
                    throw new OverdraftException("Insufficient funds for overdraft protection", amount - balance);
            }
        }
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }
}
