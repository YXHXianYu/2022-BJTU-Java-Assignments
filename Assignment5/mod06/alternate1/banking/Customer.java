package banking;

/**
 * @author YXH_XianYu
 * @create 2022-03-21
 */
public class Customer {
    private String firstName;
    private String lastName;
    private SavingsAccount savingsAccount = null;
    private CheckingAccount checkingAccount = null;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public SavingsAccount getSavings() {
        return savingsAccount;
    }
    public CheckingAccount getChecking() {
        return checkingAccount;
    }
    public void setSavings(SavingsAccount account) {
        savingsAccount = account;
    }
    public void setChecking(CheckingAccount account) {
        checkingAccount = account;
    }
}
