package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.treegrid.TreeGrid;

import java.util.List;
import java.util.function.Function;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.END;
import static java.lang.Integer.MAX_VALUE;

public class FamilyTreeHeader extends VerticalLayout implements KeyNotifier {

    public FamilyTreeHeader(TreeGrid<Dog> dogGrid, List<Dog> rootDog, Function<Integer, Void> updateTreeFunction) {
        // title
        H3 title = new H3("Ichiro Family Tree");
        title.getStyle().set("margin", "0");

        // generations input field
        Label generationsLabel = new Label("Generations");
        IntegerField generationsInput = new IntegerField();
        generationsInput.setMin(2);
        generationsInput.setMax(8);
        generationsInput.setValue(5);
        generationsInput.setHasControls(true);
        generationsInput.addValueChangeListener(event -> {
            updateTreeFunction.apply(event.getValue());
        });
        HorizontalLayout generationsLayout = new HorizontalLayout(generationsLabel, generationsInput);
        generationsLayout.setAlignItems(CENTER);

        // expand and collapse buttons
        Button expand = new Button("Expand All");
        expand.addClickListener(event -> dogGrid.expandRecursively(rootDog, MAX_VALUE));
        Button collapse = new Button("Collapse All");
        collapse.addClickListener(event -> dogGrid.collapseRecursively(rootDog, MAX_VALUE));
        HorizontalLayout buttonsLayout = new HorizontalLayout(expand, collapse);
        buttonsLayout.setAlignSelf(END);

        HorizontalLayout row = new HorizontalLayout(generationsLayout, buttonsLayout);

        add(title, row);
        setPadding(false);
    }

}
