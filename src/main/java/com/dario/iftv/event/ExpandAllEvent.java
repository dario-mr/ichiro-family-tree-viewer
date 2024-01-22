package com.dario.iftv.event;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.button.Button;

public class ExpandAllEvent extends ComponentEvent<Button> {

    public ExpandAllEvent(Button source) {
        super(source, false);
    }
}
