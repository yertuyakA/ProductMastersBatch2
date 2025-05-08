package hw3.hard;

public class Bird extends Pet{

    private String colour;

    protected Bird(String name, int age, String colour) {
        super(name, age);
        this.colour = colour;
    }

    protected Bird(String name, int age, String colour, Owner owner) {
        super(name, age, owner);
        this.colour = colour;
    }

    @Override
    public int calculateHumanAge() {
        return getAge() * 5;
    }

    @Override
    public void displayInfo() {
        if(getOwner() != null) {
            System.out.println(getOwner());
        }
        System.out.println("Birds info: " + getName() + ", " + getAge());
    }

    public void fly() {
        System.out.println("The birds colour is: " + colour);
    }
}
