package com.dario.iftv.event;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.button.Button;

public class CollapseAllEvent extends ComponentEvent<Button> {

    public CollapseAllEvent(Button source) {
        super(source, false);
    }
}
