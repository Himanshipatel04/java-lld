package Projects.ZomatoLLD;

import Projects.ZomatoLLD.Models.*;
import Projects.ZomatoLLD.Strategies.*;

public class Main {
    public static void main(String[] args) {

        TomatoApp tomato = new TomatoApp();


        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");


        java.util.List<Restaurant> restaurantList = tomato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }


        tomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());


        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);


        Order order = tomato.checkoutNow(user, "Delivery", new UPI("1234567890"));

        tomato.payForOrder(user, order);
    }
}