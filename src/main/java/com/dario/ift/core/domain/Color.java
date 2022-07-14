package com.dario.ift.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Color {

    RED("Red");

    @Getter
    private final String value;

}
