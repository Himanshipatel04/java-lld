package Projects.ZomatoLLD.Models;

public class MenuItem {
    int menuItemId;
    String itemName;
    int price;

    public MenuItem(String itemName, int price, int id) {
        this.itemName = itemName;
        this.price = price;
        this.menuItemId = id;
    }

    public void setItemId(int id) {
        this.menuItemId = id;
    }

    public int getItemId() {
        return menuItemId;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemPrice(int price) {
        this.price = price;
    }

    public int getItemPrice() {
        return price;
    }

}