package Projects.ZomatoLLD.Models;

import java.util.List;

import Projects.ZomatoLLD.Strategies.PaymentStrategy;

public abstract class Order {
    static int nextOrderId;
    int orderId;
    PaymentStrategy paymentStrategy;
    User user;
    Restaurant restaurant;
    List<MenuItem> items;
    int total;
    String scheduled;

    public Order() {
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.total = 0;
        this.scheduled = "";
        this.orderId = ++nextOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setUser(User u) {
        user = u;
    }

    public User getUser() {
        return user;
    }

    public void setRestaurant(Restaurant r) {
        restaurant = r;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public boolean processPayment(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Choose a payment strategy first");
            return false;
        }
        paymentStrategy.pay(amount);
        return true;
    }

    public void setItems(List<MenuItem> its) {
        items = its;
        total = 0;
        for (MenuItem i : items) {
            total += i.getItemPrice();
        }
    }

    public abstract String getType();

    public List<MenuItem> getItems() {
        return items;
    }

    public void setPaymentStrategy(PaymentStrategy p) {
        paymentStrategy = p;
    }

    public void setScheduled(String s) {
        scheduled = s;
    }

    public String getScheduled() {
        return scheduled;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}