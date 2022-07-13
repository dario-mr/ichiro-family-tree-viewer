package com.dario.ift.core.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Dog {
    String name;
    String country;
    String color;
    String imageUrl;
    String profileUrl;

    Dog mother;
    Dog father;
}
