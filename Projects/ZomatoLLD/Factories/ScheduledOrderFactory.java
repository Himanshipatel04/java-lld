package Projects.ZomatoLLD.Factories;

import java.util.List;

import Projects.ZomatoLLD.Models.Cart;
import Projects.ZomatoLLD.Models.DeliveryOrder;
import Projects.ZomatoLLD.Models.MenuItem;
import Projects.ZomatoLLD.Models.Order;
import Projects.ZomatoLLD.Models.PickupOrder;
import Projects.ZomatoLLD.Models.Restaurant;
import Projects.ZomatoLLD.Models.User;
import Projects.ZomatoLLD.Strategies.PaymentStrategy;

public class ScheduledOrderFactory implements OrderFactory {
    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

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
        order.setScheduled(scheduleTime);
        order.setTotal(total);
        return order;
    }
}