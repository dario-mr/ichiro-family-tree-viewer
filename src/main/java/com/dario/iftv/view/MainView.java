package com.dario.iftv.view;

import com.dario.iftv.core.gateway.FamilyTreeGateway;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@Route
@PageTitle("Ichiro Family Tree")
@RequiredArgsConstructor
public class MainView extends VerticalLayout {

    private final FamilyTreeGateway familyTreeGateway;

    @PostConstruct
    public void init() {
        setHeightFull();

        var familyTreeGrid = new FamilyTreeGrid();

        Function<Integer, Void> updateTreeFunction = generations -> {
            familyTreeGrid.setRootDog(familyTreeGateway.getFamilyTree(generations));
            return null;
        };

        updateTreeFunction.apply(5);    // by default, load 5 generations

        var header = new FamilyTreeHeader(familyTreeGrid, updateTreeFunction);

        add(header, familyTreeGrid);
    }
}
