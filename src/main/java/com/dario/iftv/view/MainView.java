package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.dario.iftv.core.gateway.FamilyTreeGateway;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Route
@RequiredArgsConstructor
@Slf4j
public class MainView extends VerticalLayout {

    private final FamilyTreeGateway familyTreeGateway;

    private final List<Dog> rootDog = new ArrayList<>();

    @PostConstruct
    public void init() {
        setHeightFull();
        rootDog.add(familyTreeGateway.getFamilyTree(5));

        FamilyTreeGrid grid = new FamilyTreeGrid();
        grid.setRootDog(rootDog);

        Function<Integer, Void> updateTreeFunction = generations -> {
            // TODO use DataProvider
            rootDog.clear();
            rootDog.add(familyTreeGateway.getFamilyTree(generations));
            grid.setRootDog(rootDog);
            return null;
        };
        FamilyTreeHeader header = new FamilyTreeHeader(grid, rootDog, updateTreeFunction);

        add(header, grid);
    }

}
