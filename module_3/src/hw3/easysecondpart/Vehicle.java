package hw3.easysecondpart;

public abstract class Vehicle {

    private String brand;
    private int year;

    protected Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public abstract void start();

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
}
