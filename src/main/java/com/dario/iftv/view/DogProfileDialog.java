package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.dario.iftv.util.Utils.createIconByGender;
import static com.dario.iftv.util.Utils.formatBirthDate;
import static com.vaadin.flow.component.Unit.PERCENTAGE;
import static com.vaadin.flow.component.html.AnchorTarget.BLANK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.END;
import static java.lang.String.format;

public class DogProfileDialog extends Dialog {

    public DogProfileDialog(Dog dog) {
        setMinWidth(30, PERCENTAGE);
        setMaxHeight(90, PERCENTAGE);

        // title
        var titleLayout = new HorizontalLayout(
                new H3(dog.getName()),
                createIconByGender(dog.getGender())
        );
        titleLayout.setAlignItems(CENTER);

        // subtitle
        var subtitleLayout = new HorizontalLayout();
        subtitleLayout.getStyle()
                .set("color", "var(--lumo-secondary-text-color)")
                .set("font-size", "var(--lumo-font-size-m)");
        if (dog.getCountry() != null) {
            subtitleLayout.add(new Span(dog.getCountry()));
        }
        if (dog.getDateOfBirth() != null) {
            subtitleLayout.add(new Span("⁃"), new Span(formatBirthDate(dog.getDateOfBirth())));
        }
        subtitleLayout.add(new Span("⁃"), new Span(format("Generation %d", dog.getGeneration())));
        if (dog.getColor() != null) {
            subtitleLayout.add(new Span("⁃"), new Span(dog.getColor()));
        }
        subtitleLayout.add(new Span("⁃"), new Anchor(dog.getProfileUrl(), "Pedigree", BLANK));

        // dog image
        var image = (dog.getImageUrl() == null || dog.getImageUrl().isBlank())
                ? new Image("/images/img-not-found.jpg", "Image not available")
                : new Image(dog.getImageUrl(), "");
        image.getStyle().set("border-radius", "var(--lumo-border-radius-l)");

        // close button
        var closeButton = new Button("Close");
        closeButton.addClickListener(event -> close());

        // complete layout
        var layout = new VerticalLayout(titleLayout, subtitleLayout, image, closeButton);
        layout.setHorizontalComponentAlignment(END, closeButton);
        layout.setHorizontalComponentAlignment(CENTER, image);
        layout.setPadding(false);

        add(layout);
    }
}
