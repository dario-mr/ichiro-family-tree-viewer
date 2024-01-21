package com.dario.iftv.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "page1", layout = MainLayout.class)
public class Page1View extends VerticalLayout {

    public Page1View() {
        add(new Text("Page 1"));
    }
}
