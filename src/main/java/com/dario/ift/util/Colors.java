package com.dario.ift.util;

import java.util.Arrays;
import java.util.List;

public class Colors {

    private static final List<String> COLORS = Arrays.asList(
            "red",
            "blue",
            "green",
            "yellow",
            "purple",
            "pink",
            "orange",
            "brown",
            "black",
            "white",
            "gray",
            "gold",
            "silver",
            "navy blue",
            "sky blue",
            "lime green",
            "teal",
            "indigo",
            "magenta",
            "violet",
            "khaki",
            "salmon",
            "crimson",
            "lavender",
            "plum",
            "blue violet",
            "olive",
            "cyan",
            "maroon",
            "beige",
            "sesame"
    );

    public static boolean contains(String color) {
        return COLORS.contains(color.trim().toLowerCase());
    }

}

