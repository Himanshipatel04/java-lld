package SOLID.OCP;

import java.util.*;


class Product {
    String name;
    int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public int calculateTotal() {
        int total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }
}

class CartPrinter {
    private Cart cart;

    public CartPrinter(Cart cart) {
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.calculateTotal());
    }
}

interface Persistence {
    public void save(Cart cart);
}

class SqlDbPersistence implements Persistence {
    @Override
    public void save(Cart cart) {
        System.out.println("Saving to sql db");
    }
}

class NoSqlDbPersistence implements Persistence {
    @Override
    public void save(Cart cart) {
        System.out.println("Saving to no sql db");
    }
}

class FilePersistence implements Persistence {
    @Override
    public void save(Cart cart) {
        System.out.println("Saving to file");
    }
}

public class OCP {
    public static void main(String[] args) {
        Cart cart = new Cart();

        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("Mouse", 2000));

        CartPrinter printer = new CartPrinter(cart);
        printer.printInvoice();

        Persistence sqlDb = new SqlDbPersistence();
        Persistence noSqlDb = new NoSqlDbPersistence();
        sqlDb.save(cart);
        noSqlDb.save(cart);
    }

}

// class CartStorage {
// private Cart cart;

// public CartStorage(Cart cart) {
// this.cart = cart;
// }

// public void saveToDatabase() {
// System.out.println("Saving cart to database...");
// }
// }

// Now suppose that we need to add two more methods for file and mongodb storage
// in cart storage. One way to do it is to write both the methods in CartStorage
// class but that would break ocp because class should be open for extending but
// closed for change. Hence we should extend the class and add those methods.
