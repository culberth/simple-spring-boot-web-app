package com.example.demo.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record Submission(
        @NotBlank @Size(max = 80) String name,
        @NotNull @Pattern(regexp = "Java|Kotlin|Groovy") String language,
        @NotNull @Min(0) @Max(100) Integer enthusiasm,
        @NotNull LocalDate date,
        @NotNull @Pattern(regexp = "Light|Dark|System") String theme,
        boolean notifications,
        @NotNull @Size(max = 500) String notes) {
}
