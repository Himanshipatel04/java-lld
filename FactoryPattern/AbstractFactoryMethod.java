package FactoryPattern;

interface MainItem {
    void prepare();
}

class DominosPizza implements MainItem {
    @Override
    public void prepare() {
        System.out.println("Preparing dominos pizza");
    }
}

class McdPizza implements MainItem {
    @Override
    public void prepare() {
        System.out.println("Preparing mcd pizza");
    }
}

interface Drink {
    void make();
}

class Coke implements Drink {
    @Override
    public void make() {
        System.out.println("Making coke");
    }
}

class Pepsi implements Drink {
    @Override
    public void make() {
        System.out.println("Making pepsi");
    }
}

interface RestaurantFactory {
    Drink createDrink();

    MainItem createMainItem();
}

class DominosFactory implements RestaurantFactory {
    @Override
    public Drink createDrink() {
        return new Coke();
    }

    @Override
    public MainItem createMainItem() {
        return new DominosPizza();
    }
}

class McdFactory implements RestaurantFactory {
    @Override
    public Drink createDrink() {
        return new Pepsi();
    }

    @Override
    public MainItem createMainItem() {
        return new McdPizza();
    }
}

public class AbstractFactoryMethod {

    public static void main(String[] args) {
        RestaurantFactory factory = new DominosFactory();
        Drink drink = factory.createDrink();
        drink.make();

        RestaurantFactory factory2 = new McdFactory();
        MainItem item = factory2.createMainItem();
        item.prepare();

    }
}
