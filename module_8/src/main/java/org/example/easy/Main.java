package main.java.org.example.easy;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person1 = Person.builder().name("Said").age(20).city("Almaty").build();
        Person person2 = Person.builder().name("Alisher").age(19).city("Astana").build();
        Person person3 = Person.builder().name("Alikhan").age(19).city("Taldykorgan").build();
        Person person4 = Person.builder().name("Zhenis").age(22).city("Almaty").build();
        Person person5 = Person.builder().name("Ruslan").age(26).city("Qaskelen").build();

        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5);

        people.forEach(System.out::println);
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> getList() {
        Person person1 = Person.builder().name("Said").age(20).city("Almaty").build();
        Person person2 = Person.builder().name("Alisher").age(19).city("Astana").build();
        Person person3 = Person.builder().name("Alikhan").age(19).city("Taldykorgan").build();
        Person person4 = Person.builder().name("Zhenis").age(22).city("Almaty").build();
        Person person5 = Person.builder().name("Ruslan").age(26).city("Qaskelen").build();

        return (List<T>) Arrays.asList(person1, person2, person3, person4, person5);
    }
}