package banking.domain;
import java.util.ArrayList;

/**
 * @author YXH_XianYu
 */
public class Bank {
    // Singleton Pattern
    private static Bank bankInstance;
    public static Bank getBank() {
        if(bankInstance == null) {
            bankInstance = new Bank();
        }
        return bankInstance;
    }
    private Bank() {
        customers = new ArrayList<Customer>();
    }

    // Other Parts
    private ArrayList<Customer> customers;

    public void addCustomer(String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName));
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    // index starts from zero !
    public Customer getCustomer(int index) {
        return customers.get(index);
    }
}
