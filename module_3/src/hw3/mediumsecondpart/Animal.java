package hw3.mediumsecondpart;

public abstract class Animal {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

    public void walk() {
        System.out.printf("%s is walking%n", name);
    }

    public String getName() {
        return name;
    }
}