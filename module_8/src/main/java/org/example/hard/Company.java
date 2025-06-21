package main.java.org.example.hard;

import lombok.Builder;
import lombok.Data;
import main.java.org.example.easy.Person;

import java.util.List;

@Data
@Builder
public class Company {

    private String name;
    private List<Person> employees;
}
