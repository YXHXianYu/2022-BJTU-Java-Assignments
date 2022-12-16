package banking;

/**
 * @author YXH_XianYu
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[10]; // > 5
    }

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
