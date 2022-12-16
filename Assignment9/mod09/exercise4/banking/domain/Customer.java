package banking.domain;

import java.util.ArrayList;

/**
 * @author YXH_XianYu
 */
public class Customer implements Comparable {
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

    // Comparable

    @Override
    public int compareTo(Object o) {
        if(o instanceof Customer) {
            if(!this.lastName.equals(((Customer)o).lastName)) {
                return this.lastName.compareTo(((Customer)o).lastName);
            } else {
                return this.firstName.compareTo(((Customer)o).firstName);
            }
        } else {
            return 0; // maybe
        }
    }
}
