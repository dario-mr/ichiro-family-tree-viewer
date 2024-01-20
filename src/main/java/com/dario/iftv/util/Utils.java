package com.dario.iftv.util;

import com.vaadin.flow.component.html.Image;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {

    public static Image createIconByGender(String gender) {
        return gender.equals("Male")
                ? new Image("/images/male-icon.png", gender)
                : new Image("/images/female-icon.png", gender);
    }

    public static String formatBirthDate(LocalDate birthDate) {
        return birthDate == null
                ? ""
                : birthDate.format(DateTimeFormatter.ofPattern("dd MMM ''yy", Locale.getDefault()));
    }
}
