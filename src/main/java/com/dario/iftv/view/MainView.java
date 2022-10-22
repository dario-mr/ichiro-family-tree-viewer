package com.dario.iftv.view;

import com.dario.iftv.core.gateway.FamilyTreeGateway;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import java.util.function.Function;

@Route
@PageTitle("Ichiro Family Tree")
@RequiredArgsConstructor
public class MainView extends VerticalLayout {

    private final FamilyTreeGateway familyTreeGateway;

    @PostConstruct
    public void init() {
        setHeightFull();

        FamilyTreeGrid grid = new FamilyTreeGrid();
        grid.setRootDog(familyTreeGateway.getFamilyTree(5));

        Function<Integer, Void> updateTreeFunction = generations -> {
            grid.setRootDog(familyTreeGateway.getFamilyTree(generations));
            return null;
        };
        FamilyTreeHeader header = new FamilyTreeHeader(grid, updateTreeFunction);

        add(header, grid);
    }

}
