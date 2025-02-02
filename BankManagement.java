class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void display() {
        super.display();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class BankManagement {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", "John Doe", 1000.00);
        account.display();
        account.setBalance(1500.00);
        System.out.println("Updated Balance: $" + account.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Jane Smith", 2500.00, 3.5);
        savingsAccount.display();
    }
}
