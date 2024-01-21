package com.dario.iftv.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "page2", layout = MainLayout.class)
public class Page2View extends VerticalLayout {

    public Page2View() {
        add(new Text("Page 2"));
    }
}
