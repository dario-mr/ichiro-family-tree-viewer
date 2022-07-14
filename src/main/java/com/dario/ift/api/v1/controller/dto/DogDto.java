package com.dario.ift.api.v1.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
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
