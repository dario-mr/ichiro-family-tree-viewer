package com.dario.iftv.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLink;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;

public class MainLayout extends AppLayout {

    public MainLayout() {
        var navBar = new HorizontalLayout(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Page 1", Page1View.class),
                new RouterLink("Page 2", Page2View.class)
        );
        navBar.setWidthFull();
        navBar.setPadding(true);
        navBar.setAlignItems(CENTER);

        addToNavbar(navBar);
    }
}
