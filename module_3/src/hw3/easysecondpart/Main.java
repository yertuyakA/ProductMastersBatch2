package hw3.easysecondpart;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW", 2024);
        Motorcycle motorcycle = new Motorcycle("Yamaha", 2018);

        Vehicle[] vehicles = {car, motorcycle};
        for(Vehicle vehicle : vehicles) {
            vehicle.start();
        }
    }
}
