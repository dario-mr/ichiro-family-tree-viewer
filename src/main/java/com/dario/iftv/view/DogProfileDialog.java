package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.dario.iftv.util.Utils.createIconByGender;
import static com.dario.iftv.util.Utils.formatBirthDate;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static java.lang.String.format;

public class DogProfileDialog extends Dialog {

    public DogProfileDialog(Dog dog) {
        setMinWidth(30, Unit.PERCENTAGE);
        setMaxHeight(90, Unit.PERCENTAGE);

        H3 name = new H3(dog.getName());
        name.getStyle().set("margin", "0");
        Image genderIcon = createIconByGender(dog.getGender());
        HorizontalLayout nameGenderLayout = new HorizontalLayout(name, genderIcon);
        nameGenderLayout.setAlignItems(CENTER);

        Span countryBirthdayColor = new Span(format("%s | %s | %s", dog.getCountry(), formatBirthDate(dog.getDateOfBirth()), dog.getColor()));
        countryBirthdayColor.getStyle()
                .set("color", "var(--lumo-secondary-text-color)")
                .set("font-size", "var(--lumo-font-size-m)");

        Image image = dog.getImageUrl().isBlank()
                ? new Image("/images/img-not-found.jpg", "Image not available")
                : new Image(dog.getImageUrl(), "");
        image.setWidthFull(); // TODO avoid vertical scrolling

        VerticalLayout layout = new VerticalLayout(nameGenderLayout, countryBirthdayColor, image);
        layout.setPadding(false);

        add(layout);
    }

}
