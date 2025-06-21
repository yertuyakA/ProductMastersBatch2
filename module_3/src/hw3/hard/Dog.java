package hw3.hard;

public class Dog extends Pet {

    private String favouriteToy;

    protected Dog(String name, int age, String favouriteToy) {
        super(name, age);
        this.favouriteToy = favouriteToy;
    }

    protected Dog(String name, int age, String favouriteToy, Owner owner) {
        super(name, age, owner);
        this.favouriteToy = favouriteToy;
    }

    /// First 2 years: each year = 10.5 human years
    /// After that: each year = 4 human years

    @Override
    public int calculateHumanAge() {
        int humanAge;
        if (getAge() <= 2) {
            humanAge = (int) (getAge() * 10.5);
        } else {
            humanAge = (int) ((2 * 10.5) + ((getAge() - 2) * 4));
        }
        return humanAge;
    }

    @Override
    public void displayInfo() {
        if(getOwner() != null) {
            System.out.println(getOwner());
        }
        System.out.println("Dogs info: " + getName() + ", " + getAge());
    }

    public void play() {
        System.out.println("The dog likes to play with: " + favouriteToy);
    }
}
