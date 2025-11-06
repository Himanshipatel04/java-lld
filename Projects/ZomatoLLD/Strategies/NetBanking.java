package Projects.ZomatoLLD.Strategies;

public class NetBanking implements PaymentStrategy {
    private String id;

    public NetBanking(String id) {
        this.id = id;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid via Netbanking");
    }
}
