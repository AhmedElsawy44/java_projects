package javaapplication4;
import java.util.ArrayList;
import java.util.List;

// Account interface
interface Account {
    void deposit(double amount);
    void withdraw(double amount);
    double calculateInterest();
    double getBalance();
}

// SavingsAccount class implementing Account
class SavingsAccount implements Account {
    private double balance;
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {
        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // Unique method for SavingsAccount
    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest);
        System.out.println("Interest applied: " + interest);
    }
}

// CurrentAccount class implementing Account
class CurrentAccount implements Account {
    private double balance;
    private double overdraftLimit;

    public CurrentAccount(double initialBalance, double overdraftLimit) {
        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Exceeds overdraft limit or invalid withdrawal amount.");
        }
    }

    @Override
    public double calculateInterest() {
        // Current accounts typically do not earn interest
        return 0;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    // Unique method for CurrentAccount
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
        System.out.println("Overdraft limit set to: " + overdraftLimit);
    }
}

// Bank class to manage accounts
class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added to the bank.");
    }

    public void displayAllBalances() {
        for (Account account : accounts) {
            System.out.println("Account balance: " + account.getBalance());
        }
    }
}

// Main class to test the banking system
public class Main {
    public static void main(String[] args) {
        // Create a bank
        Bank bank = new Bank();

        // Create savings and current accounts
        SavingsAccount savingsAccount = new SavingsAccount(1000, 5);
        CurrentAccount currentAccount = new CurrentAccount(2000, 500);

        // Add accounts to the bank
        bank.addAccount(savingsAccount);
        bank.addAccount(currentAccount);

        // Perform operations on savings account
        System.out.println("\nSavings Account Operations:");
        savingsAccount.deposit(500);
        savingsAccount.withdraw(200);
        savingsAccount.applyInterest();
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());

        // Perform operations on current account
        System.out.println("\nCurrent Account Operations:");
        currentAccount.deposit(1000);
        currentAccount.withdraw(2500);
        currentAccount.setOverdraftLimit(1000);
        currentAccount.withdraw(500);
        System.out.println("Current Account Balance: " + currentAccount.getBalance());

        // Display all account balances
        System.out.println("\nAll Account Balances:");
        bank.displayAllBalances();
    }
}