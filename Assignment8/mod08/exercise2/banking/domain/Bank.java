package banking.domain;

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
        customers = new Customer[10]; // > 5
    }

    // Other Parts
    private Customer[] customers;
    private int numberOfCustomers;

    public void addCustomer(String firstName, String lastName) {
        customers[numberOfCustomers++] = new Customer(firstName, lastName);
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    // index starts from zero !
    public Customer getCustomer(int index) {
        return customers[index];
    }
}
