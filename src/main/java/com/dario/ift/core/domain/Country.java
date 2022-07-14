package com.dario.ift.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Country {

    RU("Russia"),
    US("USA"),
    UK("United Kingdom"),
    CA("Canada"),
    JP("Japan"),
    NL("Netherlands"),
    DE("Germany"),
    UA("Ukraine"),
    AU("Australia");

    @Getter
    private final String value;

}
