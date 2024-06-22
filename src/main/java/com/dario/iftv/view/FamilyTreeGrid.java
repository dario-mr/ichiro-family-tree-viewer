package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.dario.iftv.core.service.FamilyTreeService;
import com.dario.iftv.event.CollapseAllEvent;
import com.dario.iftv.event.ExpandAllEvent;
import com.dario.iftv.event.GenerationChangeEvent;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;

import java.util.List;

import static com.dario.iftv.util.Utils.createIconByGender;
import static com.dario.iftv.util.Utils.formatBirthDate;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static java.lang.Integer.MAX_VALUE;

@CssImport(value = "./styles/grid-tree-toggle-adjust.css", themeFor = "vaadin-grid-tree-toggle")
public class FamilyTreeGrid extends TreeGrid<Dog> {

    private final FamilyTreeService familyTreeService;

    public FamilyTreeGrid(FamilyTreeService familyTreeService) {
        this.familyTreeService = familyTreeService;

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

        // on click: show dog profile
        addItemClickListener(event -> {
            var dogProfile = new DogProfile(event.getItem());
            dogProfile.open();
        });

        // load ichiro and 5 generations in the grid
        setRootDog(this.familyTreeService.getDog("Ichiro Go Takimisou", 5));
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);

        // "generation changed" event -> load the new number of generations in the grid
        ComponentUtil.addListener(
                attachEvent.getUI(),
                GenerationChangeEvent.class,
                event -> setRootDog(familyTreeService.getDog("Ichiro Go Takimisou", event.getGenerations()))
        );

        // "expand all" event
        ComponentUtil.addListener(
                attachEvent.getUI(),
                ExpandAllEvent.class,
                event -> expandRecursively(getTreeData().getRootItems(), MAX_VALUE)
        );

        // "collapse all" event
        ComponentUtil.addListener(
                attachEvent.getUI(),
                CollapseAllEvent.class,
                event -> collapseRecursively(getTreeData().getRootItems(), MAX_VALUE)
        );
    }

    private void setRootDog(Dog rootDog) {
        setItems(List.of(rootDog), Dog::getParents);
    }
}
