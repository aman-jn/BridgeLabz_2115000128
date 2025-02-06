
import java.util.*;
class Bank {
    String name;
    ArrayList<Customer>customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(String customerName, int initialBalance) {
        Customer customer = new Customer(customerName, this, initialBalance);
        customers.add(customer);
        System.out.println("Account opened for " + customerName + " in " + name + " with balance: " + initialBalance);
    }

    public void displayCustomers() {
        System.out.println("Bank: " + name);
        for (Customer customer : customers) {
            customer.viewBalance();
        }
    }
}

class Customer {
    String name;
    Bank bank;
    int balance;

    public Customer(String name, Bank bank, int balance) {
        this.name = name;
        this.bank = bank;
        this.balance = balance;
    }

    public void viewBalance() {
        System.out.println("Customer: " + name + ", Bank: " + bank.name + ", Balance: " + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner adi= new Scanner(System.in);

        System.out.print("Enter bank name: ");
        String bankName =adi.nextLine();
        Bank bank =new Bank(bankName);

        System.out.print("Enter number of customers: ");
        int numCustomers =adi.nextInt();
        adi.nextLine();

        for (int i = 0; i < numCustomers; i++) {
            System.out.print("Enter customer name: ");
            String customerName =adi.nextLine();
            System.out.print("Enter initial balance: ");
            int balance =adi.nextInt();
            adi.nextLine();
            bank.openAccount(customerName, balance);
        }

        System.out.println();
        bank.displayCustomers();
        adi.close();
    }
}
