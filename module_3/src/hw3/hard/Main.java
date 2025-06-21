package hw3.hard;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("Said", 20, 7074947523L);

        Dog dog = new Dog("Bella", 1, "Toy Bear", owner);
        Bird bird = new Bird("Beauty", 2, "blue");

        Pet[] pets =  {dog, bird};
        for(Pet pet : pets) {
            pet.displayInfo();
            System.out.println(pet.calculateHumanAge());
            System.out.println();
        }

        dog.play();
        bird.fly();

        System.out.println();

        owner.addPet(bird);
        for(Pet pet : owner.getPets()) {
            pet.displayInfo();
        }
    }
}
