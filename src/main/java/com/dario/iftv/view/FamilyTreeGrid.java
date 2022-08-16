package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

@Component
public class FamilyTreeGrid extends TreeGrid<Dog> {

    public FamilyTreeGrid() {
        addComponentHierarchyColumn(dog -> {
            Avatar avatar = new Avatar();
            avatar.setName(dog.getName());
            avatar.setImage(dog.getImageUrl());

            Span name = new Span(dog.getName());
            Icon genderIcon = createIconByGender(dog.getGender());
            HorizontalLayout nameGender = new HorizontalLayout(name, genderIcon);

            Span country = new Span(dog.getCountry());
            country.getStyle()
                    .set("color", "var(--lumo-secondary-text-color)")
                    .set("font-size", "var(--lumo-font-size-s)");

            VerticalLayout column = new VerticalLayout(nameGender, country);
            column.getStyle()
                    .set("line-height", "var(--lumo-line-height-m)");
            column.setPadding(false);
            column.setSpacing(false);

            HorizontalLayout row = new HorizontalLayout(avatar, column);
            row.setAlignItems(CENTER);
            row.setSpacing(true);
            return row;
        }).setHeader("Dog").setFlexGrow(2);

        addColumn(dog -> dog.getDateOfBirth() == null ? ""
                : dog.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd MMM ''yy", Locale.getDefault()))
        ).setHeader("Birthday");
        addColumn(Dog::getColor).setHeader("Color");
    }

    public void setRootDog(List<Dog> rootDog) {
        setItems(rootDog, Dog::getParents);
    }

    // TODO use custom icons
    private Icon createIconByGender(String gender) {
        return gender.equals("Male")
                ? createIcon(VaadinIcon.MALE)
                : createIcon(VaadinIcon.FEMALE);
    }

    private Icon createIcon(VaadinIcon vaadinIcon) {
        Icon icon = vaadinIcon.create();

        icon.getStyle()
                .set("margin-inline-end", "var(--lumo-space-s)");
        icon.setSize("var(--lumo-icon-size-s)");
        icon.setColor("#B3B3B3");
        return icon;
    }

}
