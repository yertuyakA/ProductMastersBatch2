package hw3.medium;

public class Main {

    private static final long myBankAccount = 2201032343245617L;
    public static void main(String[] args) {
        BankAccount myBank = new BankAccount(myBankAccount, 1000);

        System.out.println("Initial balance: " + myBank.getBalance());
        myBank.deposit(myBankAccount, 500);
        System.out.println("Balance after deposit: " + myBank.getBalance());
        myBank.withdraw(myBankAccount, 1400);
        System.out.println("Balance after withdrawal: " + myBank.getBalance());
    }
}
