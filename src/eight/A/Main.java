public class Main {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = new Shape[3];
        
        // Alex creates a rectangle
        shapes[0] = new Rectangle("Alex's Rectangle", 5, 4);
        
        // Bella creates a circle
        shapes[1] = new Circle("Bella's Circle", 3);
        
        // They create another shape together
        shapes[2] = new Rectangle("Alex and Bella's Square", 6, 6);

        // Calculate and display areas using polymorphism
        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " - Area: " + shape.calculateArea());
        }
    }
}

// Base class Shape
abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be overridden by subclasses
    public abstract double calculateArea();
}

// Rectangle subclass
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(String name, double length, double width) {
        super(name);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

// Circle subclass
class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}