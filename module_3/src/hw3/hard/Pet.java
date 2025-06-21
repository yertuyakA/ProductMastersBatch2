package hw3.hard;

public abstract class Pet {

    private String name;
    private int age;
    private Owner owner;

    protected Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Pet(String name, int age, Owner owner) {
        this(name, age);
        setOwner(owner);
    }

    public abstract int calculateHumanAge();

    public abstract void displayInfo();

    public void setOwner(Owner owner) {
        this.owner = owner;
        owner.addPet(this);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }
}
