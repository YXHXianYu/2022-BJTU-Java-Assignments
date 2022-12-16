package banking;

/**
 * @author YXH_XianYu
 * @create 2022-03-21
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

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
    public Account getAccount() { // retrieve the account attribute
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
