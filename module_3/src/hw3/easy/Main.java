package hw3.easy;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Bekzhan");
        Cat cat = new Cat("Barsik");
        Cow cow = new Cow("Alikhan");
        Horse horse = new Horse("Said");

        Animal[] animals = {dog, cat, cow, horse};
        for(Animal animal : animals) {
            animal.makeSound();
            animal.walk();
            System.out.println();
        }
    }
}
