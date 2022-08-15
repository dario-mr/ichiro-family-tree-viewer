package com.dario.iftv.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Dog {
    String name;
    String gender;
    String country;
    LocalDate dateOfBirth;
    String color;
    String imageUrl;
    String profileUrl;
    int generation;

    Dog mother;
    Dog father;
}
