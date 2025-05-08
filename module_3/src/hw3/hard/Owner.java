package hw3.hard;

import java.util.ArrayList;
import java.util.List;

public class Owner {

    private String name;
    private int age;
    private long contactNumber;
    private List<Pet> pets = new ArrayList<>();


    public Owner(String name, int age, long contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
