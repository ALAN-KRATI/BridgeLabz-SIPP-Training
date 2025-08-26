interface PaymentProcessor {
    void processPayment(double amount);
    default void refund(double amount) { System.out.println("Refunded: " + amount); }
}

class PayPal implements PaymentProcessor {
    public void processPayment(double amount) { System.out.println("PayPal processed: " + amount); }
}

public class PaymentGatewayDemo {
    public static void main(String[] args) {
        PaymentProcessor pp = new PayPal();
        pp.processPayment(1000);
        pp.refund(200);
    }
}
