package banking.domain;

import java.util.ArrayList;

/**
 * @author YXH_XianYu
 */
public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(int index) { // retrieve the account attribute
        return accounts.get(index);
    }

    public int getNumOfAccounts() {
        return accounts.size();
    }
}
