package Projects.ZomatoLLD.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    Restaurant restaurant;
    List<MenuItem> menuItems = new ArrayList<>();

    public Cart() {
        restaurant = null;
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public int calculateTotal() {
        int total = 0;
        for (MenuItem item : menuItems) {
            total += item.getItemPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        if (restaurant == null || menuItems.size() < 1) {
            return true;
        }
        return false;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void clear() {
        menuItems.clear();
        restaurant = null;
    }

    public List<MenuItem> getItems() {
        return menuItems;
    }
}
