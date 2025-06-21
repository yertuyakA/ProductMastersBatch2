package hw3.mediumsecondpart;

public class Horse extends Animal {

    protected Horse(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.printf("%s says igugu%n", getName());
    }

    @Override
    public void eat(Food food) {
        if (Food.GRASS.equals(food)) {
            System.out.printf("%s eats grass.%n", getName());
        } else {
            System.out.printf("%s can not eat meat.%n", getName());
        }
    }
}
