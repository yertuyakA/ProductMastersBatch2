package hw3.easy;

public class Dog extends Animal {

    private final String dogSound = "Gaf";

    protected Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says %s%n", getName(), dogSound);
    }
}
