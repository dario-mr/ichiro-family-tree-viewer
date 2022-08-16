package com.dario.iftv.core.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.emptyList;

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

    public List<Dog> getParents() {
        if (father == null || mother == null) {
            return emptyList();
        }
        return List.of(father, mother);
    }

}
