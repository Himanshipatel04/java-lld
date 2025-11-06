package Projects.ZomatoLLD.Factories;

import java.util.List;

import Projects.ZomatoLLD.Models.*;
import Projects.ZomatoLLD.Strategies.PaymentStrategy;

public interface OrderFactory {
    Order createOrder(User user, Cart cart,Restaurant restaurant, PaymentStrategy paymentStrategy, List<MenuItem> menuItem,int total,String orderType);
}
