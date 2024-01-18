package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.data.provider.hierarchy.TreeDataProvider;

import java.util.List;
import java.util.function.Function;

import static java.lang.Integer.MAX_VALUE;

@Tag("family-tree-header")
@JsModule("./src/family-tree-header.ts")
public class FamilyTreeHeader extends LitTemplate {

    @Id("generations")
    private IntegerField generations;

    @Id("expand")
    private Button expand;

    @Id("collapse")
    private Button collapse;

    public FamilyTreeHeader(Function<Integer, Void> updateTreeFunction, TreeGrid<Dog> dogGrid) {
        // generations input field
        generations.addValueChangeListener(event -> updateTreeFunction.apply(event.getValue()));

        // expand and collapse buttons
        expand.addClickListener(event -> dogGrid.expandRecursively(getRootDog(dogGrid), MAX_VALUE));
        collapse.addClickListener(event -> dogGrid.collapseRecursively(getRootDog(dogGrid), MAX_VALUE));
    }

    private static List<Dog> getRootDog(TreeGrid<Dog> dogGrid) {
        return ((TreeDataProvider<Dog>) dogGrid.getDataProvider()).getTreeData().getRootItems();
    }
}
