package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.dario.iftv.core.gateway.FamilyTreeGateway;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import java.util.List;

import static java.util.Collections.singletonList;

@Route
@RequiredArgsConstructor
public class MainView extends VerticalLayout {

    private final FamilyTreeGateway familyTreeGateway;

    @PostConstruct
    public void init() {
        setHeightFull();
        List<Dog> rootDog = singletonList(familyTreeGateway.getFamilyTree(5));

        FamilyTreeGrid grid = new FamilyTreeGrid(rootDog);
        FamilyTreeHeader header = new FamilyTreeHeader(grid, rootDog);
        // TODO add event on generations click

        add(header, grid);
    }

}
