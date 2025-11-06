package Projects.ZomatoLLD.Models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    static int nextRestaurantId;
    int restaurantId;
    String name;
    String loc;
    List<MenuItem> items = new ArrayList<>();

    public Restaurant(String name, String loc) {
        this.name = name;
        this.loc = loc;
        this.restaurantId = ++nextRestaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return name;
    }

    public void setLoc(String name) {
        this.name = name;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println("Item added successfully");
    }

    public void deleteItem(MenuItem item) {
        items.remove(item);
        System.out.println("Item deleted successfully");
    }
}
