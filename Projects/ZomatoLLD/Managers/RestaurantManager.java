package Projects.ZomatoLLD.Managers;

import java.util.ArrayList;
import java.util.List;

import Projects.ZomatoLLD.Models.Restaurant;

//Singleton
public class RestaurantManager {
    List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager() {
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println("Added restaurant");
    }

    public void deleteRestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
        System.out.println("Deleted restaurant");
    }

    public List<Restaurant> searchRestaurants(String loc) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {

            if (restaurant.getLoc() == loc) {
                result.add(restaurant);
            }
        }
        return result;
    }
}
