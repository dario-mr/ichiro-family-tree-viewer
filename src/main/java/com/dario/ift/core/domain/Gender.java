package com.dario.ift.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Gender {

    M("Male"),
    F("Female");

    @Getter
    private final String value;

}
