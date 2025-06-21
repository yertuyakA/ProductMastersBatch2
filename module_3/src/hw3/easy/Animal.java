package hw3.easy;

public abstract class Animal {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public void walk() {
        System.out.printf("%s is walking%n", name);
    }

    public String getName() {
        return name;
    }
}
