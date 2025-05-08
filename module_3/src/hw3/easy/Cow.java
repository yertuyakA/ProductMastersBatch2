package hw3.easy;

public class Cow extends Animal {

    private final String cowSound = "Muu";

    protected Cow(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says %s%n", getName(), cowSound);
    }
}
