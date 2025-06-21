package hw3.mediumsecondpart;

public class Cat extends Animal {

    protected Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says myau%n", getName());
    }

    @Override
    public void eat(Food food) {
        if (Food.MEAT.equals(food)) {
            System.out.printf("%s eats meat.%n", getName());
        } else {
            System.out.printf("%s can not eat grass.%n", getName());
        }
    }
}
