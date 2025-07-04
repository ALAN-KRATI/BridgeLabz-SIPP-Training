class BankAccount {
    String accountHolder;
    double balance;
    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    void calculateInterest() {
        System.out.println("Generic interest calculation.");
    }
}
class SavingsAccount extends BankAccount {
    SavingsAccount(String accHolder, double bal) {
        super(accHolder, bal);
    }
    void calculateInterest() {
        System.out.println("Savings interest: " + (balance * 0.04));
    }
}
class CurrentAccount extends BankAccount {
    CurrentAccount(String accHolder, double bal) {
        super(accHolder, bal);
    }
    void calculateInterest() {
        System.out.println("Current Account has no interest.");
    }
}
class FixedDepositAccount extends BankAccount {
    FixedDepositAccount(String accHolder, double bal) {
        super(accHolder, bal);
    }
    void calculateInterest() {
        System.out.println("FD interest: " + (balance * 0.08));
    }
}
class BankSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = {
            new SavingsAccount("Asha", 50000),
            new CurrentAccount("Ravi", 75000),
            new FixedDepositAccount("Meena", 100000)
        };
        for (BankAccount acc : accounts) {
            acc.calculateInterest();
        }
    }
}
