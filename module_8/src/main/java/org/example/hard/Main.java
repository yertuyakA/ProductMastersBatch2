package main.java.org.example.hard;

import main.java.org.example.easy.Person;

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

        Company company1 = Company.builder().name("a1qa").employees(people).build();
        Company company2 = Company.builder().name("kaspi").employees(
                Arrays.asList(Person.builder().name("Darkhan").age(40).city("Taldykorgan").build(),
                        Person.builder().name("Aruzhan").age(29).city("Taraz").build())
        ).build();

        List<Company> companies = Arrays.asList(company1, company2);

        first(people);
        System.out.println();
        olderThan(companies);
        averageAgeFromCompany(companies);

    }

    private static void first(List<Person> list) {
        list.stream().sorted((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge())).limit(3).forEach(System.out::println);
    }

    private static void olderThan(List<Company> companies) {
        companies.stream()
                .flatMap(c -> c.getEmployees().stream())
                .filter(p -> p.getAge() > 25)
                .forEach(System.out::println);
    }

    private static void averageAgeFromCompany(List<Company> companies) {
        Map<String, Double> companyAndAge = companies
                .stream()
                .collect(Collectors.toMap(
                        Company::getName,
                        company -> company
                                .getEmployees()
                                .stream()
                                .mapToInt(Person::getAge)
                                .average().orElse(0)
                        ));
        companyAndAge.forEach((name, avgAge) ->
                System.out.println(name + " → " + avgAge));
    }
}
