package SOLID.LSP.SignatureRules;

// Method Argument Rule : 
// Subtype method arguments can be identical or wider than the supertype
// Java enforces this by requiring the same method signature for overrides

class Animal {

}

class Dog extends Animal {

}

class Parent {
    public Animal getAnimal() {
        System.out.println("parent class");
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    public Dog getAnimal() {
        System.out.println("child class");
        return new Dog();
    }
}

class Client {
    Parent p;

    public Client(Parent arg) {
        this.p = arg;
    }

    public void takeAnimal() {
        p.getAnimal();
    }
}

public class MethodReturnType {
    public static void main(String[] args) {
        Child c = new Child();
        Parent p = new Parent();

        Client cl = new Client(p);
        cl.takeAnimal();
        Client cll = new Client(c);
        cll.takeAnimal();

    }
}
