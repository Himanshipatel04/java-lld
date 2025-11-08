package Projects.ZomatoLLD.Models;

public class MenuItem {
    String menuItemId;
    String itemName;
    int price;

    public MenuItem(String id,String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
        this.menuItemId = id;
    }

    public void setItemId(String id) {
        this.menuItemId = id;
    }

    public String getItemId() {
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