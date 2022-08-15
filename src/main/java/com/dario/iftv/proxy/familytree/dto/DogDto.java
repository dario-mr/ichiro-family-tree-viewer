package com.dario.iftv.proxy.familytree.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DogDto {
    String name;
    String gender;
    String country;
    LocalDate dateOfBirth;
    String color;
    String imageUrl;
    String profileUrl;
    int generation;

    DogDto mother;
    DogDto father;
}
