package com.dario.iftv.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "home", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new Text("Home"));
    }
}
