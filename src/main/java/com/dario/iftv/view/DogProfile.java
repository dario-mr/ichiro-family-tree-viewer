package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.dario.iftv.util.PathResolver;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.dario.iftv.util.Utils.createIconByGender;
import static com.dario.iftv.util.Utils.formatBirthDate;
import static com.vaadin.flow.component.html.AnchorTarget.BLANK;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static com.vaadin.flow.component.orderedlayout.FlexLayout.FlexWrap.WRAP;
import static java.lang.String.format;

@CssImport(value = "./styles/dog-dialog.css")
@CssImport(value = "./styles/vaadin-dialog-overlay.css", themeFor = "vaadin-dialog-overlay")
public class DogProfile extends Dialog {

    public DogProfile(Dog dog) {
        // dog image
        var dogImage = (dog.getImageUrl() == null || dog.getImageUrl().isBlank())
                ? new Image(PathResolver.resolve("/images/img-not-found.jpg"), "Image not available")
                : new Image(dog.getImageUrl(), "");
        dogImage.getStyle().set("object-fit", "contain");
        dogImage.setWidthFull();
        dogImage.setMaxHeight("50vh");

        // close button
        var closeButton = new Button(VaadinIcon.CLOSE_CIRCLE.create());
        closeButton.addClassName("close-button");
        closeButton.addClickListener(event -> close());

        // image container (dog image + close button)
        var imageContainer = new Div(dogImage, closeButton);
        imageContainer.addClassName("image-container");

        // title
        var title = new HorizontalLayout(
                new H3(dog.getName()),
                createIconByGender(dog.getGender()));
        title.setAlignItems(CENTER);

        // subtitle
        var subtitle = new FlexLayout();
        subtitle.setFlexWrap(WRAP);
        subtitle.setWidthFull();
        subtitle.getStyle()
                .set("color", "var(--lumo-secondary-text-color)")
                .set("font-size", "var(--lumo-font-size-m)");
        if (dog.getCountry() != null) {
            subtitle.add(new Span(dog.getCountry()));
        }
        if (dog.getDateOfBirth() != null) {
            subtitle.add(new Span(" ∙ "), new Span(formatBirthDate(dog.getDateOfBirth())));
        }
        subtitle.add(new Span(" ∙ "), new Span(format("Generation %d", dog.getGeneration())));
        subtitle.add(new Span(" ∙ "), new Anchor(dog.getProfileUrl(), "Pedigree", BLANK));

        // title + subtitle
        var titleSubtitle = new VerticalLayout(title, subtitle);
        titleSubtitle.setPadding(true);

        add(imageContainer, titleSubtitle);
    }
}
