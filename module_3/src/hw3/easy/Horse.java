package hw3.easy;

public class Horse extends Animal {

    private final String horseSound = "Igogo";

    protected Horse(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says %s%n", getName(), horseSound);
    }
}
