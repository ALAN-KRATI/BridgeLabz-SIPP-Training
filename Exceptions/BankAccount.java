import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0)
            throw new IllegalArgumentException("Invalid amount!");
        if (amount > balance)
            throw new InsufficientBalanceException("Insufficient balance!");
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);
        try {
            acc.withdraw(200);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
