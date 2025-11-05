package SOLID.LSP.SignatureRules;

class Animal {

}

class Dog extends Animal {

}

class Parent {
    public void fun(Dog d) {
        System.out.println("parent class");
    }
}

class Child extends Parent {
    @Override
    public void fun(Dog d) {
        System.out.println("child class");
    }
}

class Client {
    Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void run() {
        p.fun(new Dog());
    }
}

public class MethodArgument {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();
        Client c0 = new Client(p);
        Client c1 = new Client(c);
        c0.run();
        c1.run();
    }
}
