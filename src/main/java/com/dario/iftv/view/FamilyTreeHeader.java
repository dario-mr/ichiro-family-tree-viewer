package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.data.provider.hierarchy.TreeDataProvider;

import java.util.List;
import java.util.function.Function;

import static java.lang.Integer.MAX_VALUE;

public class FamilyTreeHeader extends VerticalLayout {

    public FamilyTreeHeader(TreeGrid<Dog> dogGrid, Function<Integer, Void> updateTreeFunction) {
        setPadding(false);

        // title
        var title = new H3("Ichiro Family Tree");

        // generations input field
        var generationsInput = new IntegerField("Generations", 5, event -> updateTreeFunction.apply(event.getValue()));
        generationsInput.setMin(2);
        generationsInput.setMax(6);
        generationsInput.setStepButtonsVisible(true);

        // expand and collapse buttons
        var expand = new Button("Expand All");
        expand.addClickListener(event -> dogGrid.expandRecursively(getRootDog(dogGrid), MAX_VALUE));

        var collapse = new Button("Collapse All");
        collapse.addClickListener(event -> dogGrid.collapseRecursively(getRootDog(dogGrid), MAX_VALUE));

        var row = new HorizontalLayout(generationsInput, expand, collapse);
        row.setAlignItems(Alignment.END);

        add(title, row);
    }

    private static List<Dog> getRootDog(TreeGrid<Dog> dogGrid) {
        return ((TreeDataProvider<Dog>) dogGrid.getDataProvider()).getTreeData().getRootItems();
    }
}
