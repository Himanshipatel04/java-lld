package Projects.ZomatoLLD.Factories;

import java.util.List;

import Projects.ZomatoLLD.Models.*;
import Projects.ZomatoLLD.Strategies.PaymentStrategy;
import Projects.ZomatoLLD.Utils.TimeUtils;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, PaymentStrategy paymentStrategy,
            List<MenuItem> menuItems, int total,
            String orderType) {
        Order order = null;

        if (orderType.equals("Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLoc());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(total);
        return order;
    }
}