package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.dario.iftv.util.Utils.createIconByGender;
import static com.dario.iftv.util.Utils.formatBirthDate;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Slf4j
@CssImport(value = "./styles/grid-tree-toggle-adjust.css", themeFor = "vaadin-grid-tree-toggle")
public class FamilyTreeGrid extends TreeGrid<Dog> {

    public FamilyTreeGrid() {
        // columns
        addComponentHierarchyColumn(dog -> {
            Avatar avatar = new Avatar();
            avatar.setName(dog.getName());
            avatar.setImage(dog.getImageUrl());

            Span name = new Span(dog.getName());
            name.getStyle().set("font-size", "var(--lumo-font-size-m)");
            Image genderIcon = createIconByGender(dog.getGender());
            HorizontalLayout nameGenderLayout = new HorizontalLayout(name, genderIcon);
            nameGenderLayout.setAlignItems(CENTER);

            Span country = new Span(dog.getCountry());
            country.getStyle()
                    .set("color", "var(--lumo-secondary-text-color)")
                    .set("font-size", "var(--lumo-font-size-m)");

            VerticalLayout nameGenderCountryLayout = new VerticalLayout(nameGenderLayout, country);
            nameGenderCountryLayout.getStyle()
                    .set("line-height", "1.8");
            nameGenderCountryLayout.setPadding(false);
            nameGenderCountryLayout.setSpacing(false);

            HorizontalLayout row = new HorizontalLayout(avatar, nameGenderCountryLayout);
            row.setAlignItems(CENTER);
            row.setSpacing(true);
            return row;
        }).setHeader("Dog").setFlexGrow(4);

        addColumn(dog -> formatBirthDate(dog.getDateOfBirth())).setHeader("Birthdate");
        addColumn(Dog::getGeneration).setHeader("Generation");
        addColumn(Dog::getColor).setHeader("Color");

        // on click: show dog profile
        addItemClickListener(event -> {
            DogProfileDialog dogProfile = new DogProfileDialog(event.getItem());
            dogProfile.open();
        });
    }

    public void setRootDog(Dog rootDog) {
        setItems(List.of(rootDog), Dog::getParents);
    }
}
