package FactoryPattern;

interface Meal {
    void prepare();
    void deliver();
}

class Pizza implements Meal {
    @Override
    public void prepare() {
        System.out.println("Preparing Pizza with cheese and toppings");
    }

    @Override
    public void deliver() {
        System.out.println("Delivering Pizza in a box");
    }
}

class Burger implements Meal {
    @Override
    public void prepare() {
        System.out.println("Preparing Burger with lettuce and sauce");
    }

    @Override
    public void deliver() {
        System.out.println("Delivering Burger in a paper wrap");
    }
}


interface MealFactory {
    Meal createMeal();
}


class PizzaFactory implements MealFactory {
    @Override
    public Meal createMeal() {
        return new Pizza();
    }
}

class BurgerFactory implements MealFactory {
    @Override
    public Meal createMeal() {
        return new Burger();
    }
}


public class FactoryMethod {
    public static void main(String[] args) {

        MealFactory pizzaFactory = new PizzaFactory();
        Meal pizza = pizzaFactory.createMeal();
        pizza.prepare();

     
        MealFactory burgerFactory = new BurgerFactory();
        Meal burger = burgerFactory.createMeal();
        burger.prepare();

    }
}
