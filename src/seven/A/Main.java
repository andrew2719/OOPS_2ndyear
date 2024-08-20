public class Main {
    public static void main(String[] args) {
        Mammal lion = new Mammal("Simba", "Lion", "Golden");
        Bird sparrow = new Bird("Chirpy", "Sparrow", 20.5);
        Reptile snake = new Reptile("Slither", "Python", true);

        Animal[] animals = {lion, sparrow, snake};

        for (Animal animal : animals) {
            System.out.println("\nAnimal: " + animal.getName() + " (" + animal.getSpecies() + ")");
            animal.eat();
            animal.makeSound();
            animal.move();

            if (animal instanceof Mammal) {
                Mammal mammal = (Mammal) animal;
                System.out.println("Fur color: " + mammal.getFurColor());
            } else if (animal instanceof Bird) {
                Bird bird = (Bird) animal;
                System.out.println("Wingspan: " + bird.getWingspan() + " cm");
            } else if (animal instanceof Reptile) {
                Reptile reptile = (Reptile) animal;
                System.out.println("Cold-blooded: " + reptile.isColdBlooded());
            }
        }
    }
}

// Abstract base class Animal
abstract class Animal {
    protected String name;
    protected String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public abstract void eat();
    public abstract void makeSound();
    public abstract void move();

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
}

// Mammal subclass
class Mammal extends Animal {
    private String furColor;

    public Mammal(String name, String species, String furColor) {
        super(name, species);
        this.furColor = furColor;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating meat.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is roaring.");
    }

    @Override
    public void move() {
        System.out.println(name + " is running.");
    }

    public String getFurColor() {
        return furColor;
    }
}

// Bird subclass
class Bird extends Animal {
    private double wingspan;

    public Bird(String name, String species, double wingspan) {
        super(name, species);
        this.wingspan = wingspan;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating seeds.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is chirping.");
    }

    @Override
    public void move() {
        System.out.println(name + " is flying.");
    }

    public double getWingspan() {
        return wingspan;
    }
}

// Reptile subclass
class Reptile extends Animal {
    private boolean isColdBlooded;

    public Reptile(String name, String species, boolean isColdBlooded) {
        super(name, species);
        this.isColdBlooded = isColdBlooded;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating insects.");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " is hissing.");
    }

    @Override
    public void move() {
        System.out.println(name + " is crawling.");
    }

    public boolean isColdBlooded() {
        return isColdBlooded;
    }
}