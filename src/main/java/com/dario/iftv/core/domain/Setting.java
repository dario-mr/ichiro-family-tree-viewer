package com.dario.iftv.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Setting {

    IS_DARK_THEME("isDarkTheme", "true");

    private final String name;
    private final String defaultValue;
}
