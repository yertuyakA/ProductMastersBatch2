package main.java.org.example.medium;

import main.java.org.example.easy.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person1 = Person.builder().name("Said").age(20).city("Almaty").build();
        Person person2 = Person.builder().name("Alisher").age(10).city("Astana").build();
        Person person3 = Person.builder().name("Alikhan").age(15).city("Taldykorgan").build();
        Person person4 = Person.builder().name("Zhenis").age(22).city("Almaty").build();
        Person person5 = Person.builder().name("Ruslan").age(26).city("Qaskelen").build();

        List<Person> people = Arrays.asList(person1, person2, person3, person4, person5);

        filetByAge(people);
        middleAge(people);
        filerByCity(people);
        getNameAndAge(people);

    }

    private static void filetByAge(List<Person> list) {
        list.stream().filter(i -> i.getAge() > 18).forEach(System.out::println);
    }

    private static void middleAge(List<Person> list) {
        double averageAge = list.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.println(averageAge);
    }

    private static void filerByCity(List<Person> list) {
        list.stream().filter(p -> p.getCity().equals("Almaty")).map(Person::getName).forEach(System.out::println);
    }

    private static void getNameAndAge(List<Person> list) {
        Map<String, Integer> nameAge = list.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
        nameAge.forEach((name, age) ->
                System.out.println("Name: " + name + ", Age: " + age));

    }

}
