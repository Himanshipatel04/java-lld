package SOLID.ISP;

//Many client specific interfaces are better than one general purpose interface.
//Client should not be forced to depend on interfaces they do not use or use methods that it does not hold.

//suppose that there is an interface Vehicle with methods like drive, fly, sail. Now if a class Car implements Vehicle interface, it would be forced to implement fly and sail methods which it does not use. This violates ISP. To adhere to ISP, we can create separate interfaces like Drivable, Flyable, Sailable and let Car implement only Drivable interface.




// Separate interface for 2D shapes
interface TwoDimensionalShape {
    double area();
}

// Separate interface for 3D shapes
interface ThreeDimensionalShape {
    double area();
    double volume();
}

// Square implements only the 2D interface
class Square implements TwoDimensionalShape {
    private double side;

    public Square(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Rectangle implements only the 2D interface
class Rectangle implements TwoDimensionalShape {
    private double length, width;

    public Rectangle(double l, double w) {
        this.length = l;
        this.width  = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Cube implements the 3D interface
class Cube implements ThreeDimensionalShape {
    private double side;

    public Cube(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

public class ISP {
    public static void main(String[] args) {
        TwoDimensionalShape square    = new Square(5);
        TwoDimensionalShape rectangle = new Rectangle(4, 6);
        ThreeDimensionalShape cube     = new Cube(3);

        System.out.println("Square Area: "    + square.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Cube Area: "      + cube.area());
        System.out.println("Cube Volume: "    + cube.volume());
    }
}