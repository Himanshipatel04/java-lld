package Projects.ZomatoLLD.Strategies;

public class UPI implements PaymentStrategy {
    private String mobile;

    public UPI(String mob) {
        this.mobile = mob;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using UPI (" + mobile + ")");
    }
}