import java.util.*;
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance + ", Interest: " + calculateInterest());
    }
}

interface Loanable {
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public boolean applyForLoan(double amount) {
        return getBalance() > amount * 0.2;
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }
}

class CurrentAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("ACC123", "Alice", 5000));
        accounts.add(new CurrentAccount("ACC456", "Bob", 10000));

        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            if (account instanceof Loanable) {
                System.out.println("Loan Eligibility: " + ((Loanable) account).calculateLoanEligibility());
            }
            System.out.println("----------------------");
        }
    }
}
