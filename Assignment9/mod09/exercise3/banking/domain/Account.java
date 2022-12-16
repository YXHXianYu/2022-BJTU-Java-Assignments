package banking.domain;

public class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }
    public void withdraw (double amount) throws OverdraftException {
        if(amount <= balance) {
            balance -= amount;
        } else {
            throw new OverdraftException("Insufficient funds", amount - balance);
        }
    }
}
