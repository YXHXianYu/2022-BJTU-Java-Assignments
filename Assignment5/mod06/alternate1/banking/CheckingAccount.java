package banking;

/**
 * @author YXH_XianYu
 * @create 2022-04-02
 */

public class CheckingAccount extends Account {
    /**
     * protectBy用于保护当前账号。
     * 在当前帐号钱不足的情况下，
     * 如果protectBy指向的账号有足够余额，
     * 就会消耗指向账号的余额
     */
    private SavingsAccount protectedBy = null;

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, SavingsAccount protect) {
        super(balance);
        protectedBy = protect;
    }

    @Override
    public boolean withdraw(double amount) {
        // overdraftProtection 保护金额，作用等同于 exercise1 里的同名变量
        double overdraftProtection = 0.0;
        // 如果绑定了保护账号，才有保护金额
        if(protectedBy != null)
            overdraftProtection = protectedBy.getBalance();

        // 本账号，钱够
        if(amount <= balance) {
            balance -= amount;
            return true;
        }
        else {
            // 本账号+保护账号，钱够
            if(amount <= balance + overdraftProtection) {
                // 要修改保护账号内的金额，而不是这个overdraftProtection局部变量
                protectedBy.withdraw(amount - balance);
                balance = 0;
                return true;
            }
            // 钱不够
            else {
                return false;
            }
        }
    }
}
