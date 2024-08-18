// Main.java

abstract class Character {
    protected String name;
    protected int health;
    protected int level;

    public Character(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return name + ": Health = " + health + ", Level = " + level;
    }
}

class Warrior extends Character {
    public Warrior(String name, int health, int level) {
        super(name, health, level);
    }

    @Override
    public void attack(Character target) {
        int damage = 10 + this.level * 2;
        target.takeDamage(damage);
        System.out.println(this.name + " attacked " + target.getName() + " for " + damage + " damage.");
    }

    public void shieldAttack(Character target) {
        int damage = 15 + this.level * 3;
        target.takeDamage(damage);
        System.out.println(this.name + " used a shield attack on " + target.getName() + ". " + target.getName() + " took " + damage + " damage.");
    }
}

class Mage extends Character {
    public Mage(String name, int health, int level) {
        super(name, health, level);
    }

    @Override
    public void attack(Character target) {
        int damage = 8 + this.level * 3;
        target.takeDamage(damage);
        System.out.println(this.name + " attacked " + target.getName() + " for " + damage + " damage.");
    }

    public void castSpell(Character target) {
        int damage = 20 + this.level * 4;
        target.takeDamage(damage);
        System.out.println(this.name + " used a magical spell on " + target.getName() + ". " + target.getName() + " took " + damage + " damage.");
    }
}

class Archer extends Character {
    public Archer(String name, int health, int level) {
        super(name, health, level);
    }

    @Override
    public void attack(Character target) {
        int damage = 12 + this.level * 2;
        target.takeDamage(damage);
        System.out.println(this.name + " attacked " + target.getName() + " for " + damage + " damage.");
    }

    public void shootArrow(Character target) {
        int damage = 18 + this.level * 3;
        target.takeDamage(damage);
        System.out.println(this.name + " used an arrow on " + target.getName() + ". " + target.getName() + " took " + damage + " damage.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create characters
        Warrior bob = new Warrior("Bob", 150, 5);
        Mage alice = new Mage("Alice", 100, 4);
        Archer mike = new Archer("Mike", 90, 3);
        Warrior lisa = new Warrior("Lisa", 100, 2);

        // Simulate battles
        System.out.println("Warrior Bob (Level 5) vs. Mage Alice (Level 4)");
        System.out.println("----------------------------------------------");
        System.out.println("Before Battle:");
        System.out.println(bob);
        System.out.println(alice);
        System.out.println("Battle Result:");
        bob.shieldAttack(alice);
        alice.castSpell(bob);
        System.out.println("After Battle:");
        System.out.println(bob);
        System.out.println(alice);

        System.out.println("\nArcher Mike (Level 3) vs. Warrior Lisa (Level 2)");
        System.out.println("----------------------------------------------");
        System.out.println("Before Battle:");
        System.out.println(mike);
        System.out.println(lisa);
        System.out.println("Battle Result:");
        mike.shootArrow(lisa);
        lisa.shieldAttack(mike);
        System.out.println("After Battle:");
        System.out.println(mike);
        System.out.println(lisa);
    }
}