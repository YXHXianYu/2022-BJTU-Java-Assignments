package banking.domain;

/**
 * @author YXH_XianYu
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numberOfAccounts;
    private int maxNumberOfAccounts = 10;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new Account[maxNumberOfAccounts];
        numberOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account account) {
        accounts[numberOfAccounts++] = account;
    }

    public Account getAccount(int index) { // retrieve the account attribute
        return accounts[index];
    }

    public int getNumOfAccounts() {
        return numberOfAccounts;
    }
}
