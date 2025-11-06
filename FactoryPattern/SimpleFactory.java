package FactoryPattern;

import java.util.Scanner;

interface Burger {
    void prepare();
}

class SimpleBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing simple burger");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing standard burger");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing premium burger");
    }
}

class BurgerFactory {
    Burger create(String type) {
        if (type.equalsIgnoreCase("simple")) {
            return new SimpleBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger();
        } else {
            System.out.println("Invalid burger type");
            return null;
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter burger type (simple / standard / premium): ");
        String type = sc.nextLine();

        Burger burger = new BurgerFactory().create(type);
        if (burger != null) {
            burger.prepare();
        }

        sc.close();
    }
}
