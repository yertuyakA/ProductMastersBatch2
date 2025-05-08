package hw3.mediumsecondpart;

public class Dog extends Animal {

    protected Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says gaf%n", getName());
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
