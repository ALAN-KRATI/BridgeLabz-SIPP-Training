interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) { System.out.println("Paid via UPI: " + amount); }
}

class CreditCard implements Payment {
    public void pay(double amount) { System.out.println("Paid via Credit Card: " + amount); }
}

class Wallet implements Payment {
    public void pay(double amount) { System.out.println("Paid via Wallet: " + amount); }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment p1 = new UPI();
        Payment p2 = new CreditCard();
        Payment p3 = new Wallet();
        p1.pay(500);
        p2.pay(1200);
        p3.pay(300);
    }
}
