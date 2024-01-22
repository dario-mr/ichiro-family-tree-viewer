package com.dario.iftv.event;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.textfield.IntegerField;
import lombok.Getter;

@Getter
public class GenerationChangeEvent extends ComponentEvent<IntegerField> {

    private final int generations;

    public GenerationChangeEvent(IntegerField source, int generations) {
        super(source, false);
        this.generations = generations;
    }
}
