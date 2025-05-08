package hw3.easy;

public class Cat extends Animal {

    private final String catSound = "Myau";

    protected Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says %s%n", getName(), catSound);
    }
}
