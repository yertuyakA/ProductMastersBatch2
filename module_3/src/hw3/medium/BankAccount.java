package hw3.medium;

public class BankAccount {

    private long bankAccount;
    private double balance;

    BankAccount(long bankAccount, double balance) {
        this.bankAccount = bankAccount;
        this.balance = balance;
    }

    public void deposit(long bankAccount, double balanceToAdd) {
        if (bankAccount != this.bankAccount) {
            System.out.println("Enter valid bankAccount. " + bankAccount + " is incorrect");
        }
        balance += balanceToAdd;
    }

    public void withdraw(long bankAccount, double balanceToWithdraw) {
        if (bankAccount != this.bankAccount) {
            System.out.println("Enter valid bankAccount. " + " is incorrect");
        }
        if (balance - balanceToWithdraw < 0) {
            System.out.println("You do not have right amount of money. Current balance: " + balance);
        }
        balance -= balanceToWithdraw;
    }

    public double getBalance() {
        return balance;
    }
}
