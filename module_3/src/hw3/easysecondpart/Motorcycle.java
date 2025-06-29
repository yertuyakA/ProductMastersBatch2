package hw3.easysecondpart;

public class Motorcycle extends Vehicle{

    protected Motorcycle(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void start() {
        System.out.println("Motorcycle " + getBrand() + ":" + getYear() + " started");
    }
}
