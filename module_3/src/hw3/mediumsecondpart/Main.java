package hw3.mediumsecondpart;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        Dog dog = new Dog("Bella");
        Horse horse = new Horse("Aigyr");
        Cow cow = new Cow("Murka");

        Animal[] animals = {dog, cat, cow, horse};
        for(Animal animal : animals) {
            animal.makeSound();
            animal.walk();
            animal.eat(Food.MEAT);
            System.out.println();
        }
    }
}
