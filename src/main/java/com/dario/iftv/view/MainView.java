package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.dario.iftv.core.gateway.FamilyTreeGateway;
import com.dario.iftv.repository.jpa.CustomerRepository;
import com.dario.iftv.repository.jpa.entity.CustomerEntity;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Route
@RequiredArgsConstructor
public class MainView extends VerticalLayout {

    private final CustomerRepository repo;
    private final CustomerEditor editor;
    private final FamilyTreeGateway familyTreeGateway;

    private final Grid<CustomerEntity> grid = new Grid<>(CustomerEntity.class);

    @PostConstruct
    public void init() {
        Button addNewBtn = new Button("New customer", VaadinIcon.PLUS.create());
        TextField filter = new TextField();

        Dog dog = familyTreeGateway.getFamilyTree(5);

        // build layout
        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
        add(actions, grid, editor);

        grid.setHeight("300px");
        grid.setColumns("id", "firstName", "lastName");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        filter.setValueChangeMode(ValueChangeMode.EAGER);
        filter.addValueChangeListener(e -> listCustomers(e.getValue()));

        // Connect selected CustomerEntity to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editCustomer(e.getValue());
        });

        // Instantiate and edit new CustomerEntity the new button is clicked
        addNewBtn.addClickListener(e -> editor.editCustomer(new CustomerEntity("", "")));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listCustomers(filter.getValue());
        });

        // Initialize listing
        listCustomers(null);
    }

    void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repo.findAll());
        } else {
            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
        }
    }

}
