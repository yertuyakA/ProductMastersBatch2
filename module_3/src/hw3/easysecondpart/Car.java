package hw3.easysecondpart;

public class Car extends Vehicle{

    protected Car(String brand, int year) {
        super(brand, year);
    }

    @Override
    public void start() {
        System.out.println("Car " + getBrand() + ":" + getYear() + " started");
    }
}
