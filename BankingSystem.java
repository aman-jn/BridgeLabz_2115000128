import java.util.*;

class Account {
    String accountNumber;
    double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return accountNumber + " - $" + balance;
    }
}

public class BankingSystem {

    Map<String, Double> customerAccounts = new HashMap<>();
    TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        customerAccounts.put(accountNumber, balance);
        sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void processWithdrawal(String accountNumber, double amount) {
        if (customerAccounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber + ":" + amount);
        }
    }

    public void executeWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String[] request = withdrawalQueue.poll().split(":");
            String accountNumber = request[0];
            double amount = Double.parseDouble(request[1]);
            double currentBalance = customerAccounts.get(accountNumber);
            
            if (currentBalance >= amount) {
                sortedByBalance.get(currentBalance).remove(accountNumber);
                if (sortedByBalance.get(currentBalance).isEmpty()) {
                    sortedByBalance.remove(currentBalance);
                }

                double newBalance = currentBalance - amount;
                customerAccounts.put(accountNumber, newBalance);
                sortedByBalance.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

                System.out.println("Withdrawal of $" + amount + " successful for account " + accountNumber);
            } else {
                System.out.println("Insufficient funds for account " + accountNumber);
            }
        }
    }

    public Map<String, Double> getCustomerAccounts() {
        return customerAccounts;
    }

    public TreeMap<Double, List<String>> getSortedByBalance() {
        return sortedByBalance;
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("A001", 5000.00);
        bank.addAccount("A002", 3000.00);
        bank.addAccount("A003", 7000.00);
        bank.addAccount("A004", 1000.00);

        System.out.println("Customer Accounts (HashMap): " + bank.getCustomerAccounts());
        System.out.println("Accounts Sorted by Balance (TreeMap): " + bank.getSortedByBalance());

        bank.processWithdrawal("A001", 1200.00);
        bank.processWithdrawal("A003", 8000.00);
        bank.processWithdrawal("A004", 500.00);

        bank.executeWithdrawals();

        System.out.println("Updated Customer Accounts (HashMap): " + bank.getCustomerAccounts());
        System.out.println("Updated Accounts Sorted by Balance (TreeMap): " + bank.getSortedByBalance());
    }
}
