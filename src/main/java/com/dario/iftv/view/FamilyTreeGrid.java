package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;

import java.util.List;

import static com.dario.iftv.util.Utils.createIconByGender;
import static com.dario.iftv.util.Utils.formatBirthDate;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class FamilyTreeGrid extends TreeGrid<Dog> {

    public FamilyTreeGrid() {
        // columns
        addComponentHierarchyColumn(dog -> {
            var nameGenderLayout = new HorizontalLayout(
                    new Span(dog.getName()),
                    createIconByGender(dog.getGender())
            );
            nameGenderLayout.setAlignItems(CENTER);

            var country = new Span(dog.getCountry());
            country.getStyle()
                    .set("color", "var(--lumo-secondary-text-color)")
                    .set("font-size", "var(--lumo-font-size-m)");

            var nameGenderCountryLayout = new VerticalLayout(nameGenderLayout, country);
            nameGenderCountryLayout.getStyle().set("line-height", "1.8");
            nameGenderCountryLayout.setPadding(false);
            nameGenderCountryLayout.setSpacing(false);

            var row = new HorizontalLayout(
                    new Avatar(dog.getName(), dog.getImageUrl()),
                    nameGenderCountryLayout
            );
            row.setAlignItems(CENTER);
            return row;
        }).setHeader("Dog").setFlexGrow(4);

        addColumn(dog -> formatBirthDate(dog.getDateOfBirth())).setHeader("Birthdate");
        addColumn(Dog::getGeneration).setHeader("Generation");
        addColumn(Dog::getColor).setHeader("Color");

        // on click: show dog profile
        addItemClickListener(event -> {
            var dogProfile = new DogProfileDialog(event.getItem());
            dogProfile.open();
        });
    }

    public void setRootDog(Dog rootDog) {
        setItems(List.of(rootDog), Dog::getParents);
    }
}
