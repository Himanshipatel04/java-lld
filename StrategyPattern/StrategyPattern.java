package StrategyPattern;

interface Payment {
    void pay(int amount);
}

class CreditCardPayment implements Payment {
    private String creditCardNumber;

    public CreditCardPayment(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + creditCardNumber);
    }
}

class PaypalPayment implements Payment {
    private String paypalId;

    public PaypalPayment(String id) {
        this.paypalId = id;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal ID: " + paypalId);
    }
}

class PaymentHandler {
    private Payment type;

    public PaymentHandler(Payment type) {
        this.type = type;
    }

    public void setPaymentMethod(Payment type) {
        this.type = type;
    }

    public void pay(int amount) {
        if (type == null) {
            System.out.println("Select a payment method first");
            return;
        }
        type.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {

        PaymentHandler handler = new PaymentHandler(new CreditCardPayment("1234-5678-9999"));
        handler.pay(5000);


        handler.setPaymentMethod(new PaypalPayment("himi@paypal.com"));
        handler.pay(2000);
    }
}
