package main.java.org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GroupDto {
    private int id;
    private String name;
}
