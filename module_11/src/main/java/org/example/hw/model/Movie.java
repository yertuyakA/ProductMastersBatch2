package org.example.hw.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    @NotBlank(message = "Title must not be blank")
    private String title;
    @NotBlank(message = "Name must not be blank")
    private String directorName;
    @Min(value = 1900, message = "Year must be 1900 or later")
    @Max(value = 2026, message = "Year can not be from future")
    private int year;
}
