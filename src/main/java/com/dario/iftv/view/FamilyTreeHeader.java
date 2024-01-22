package com.dario.iftv.view;

import com.dario.iftv.event.CollapseAllEvent;
import com.dario.iftv.event.ExpandAllEvent;
import com.dario.iftv.event.GenerationChangeEvent;
import com.vaadin.componentfactory.ToggleButton;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.WebStorage;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.theme.lumo.Lumo;

import static com.dario.iftv.core.domain.Setting.IS_DARK_THEME;
import static java.lang.Boolean.parseBoolean;

public class FamilyTreeHeader extends VerticalLayout {

    public FamilyTreeHeader() {
        setPadding(false);

        var titleRow = buildTitleRow();
        var generationRow = buildGenerationRow();

        add(titleRow, generationRow);
    }

    private HorizontalLayout buildTitleRow() {
        // title
        var title = new H2("Ichiro Family Tree");
        title.getStyle().set("text-align", "center");

        // theme toggle
        var themeToggle = buildThemeToggle();

        var titleRow = new HorizontalLayout(title, themeToggle);
        titleRow.setWidthFull();
        titleRow.expand(title);
        titleRow.setAlignItems(Alignment.CENTER);

        return titleRow;
    }

    private ToggleButton buildThemeToggle() {
        var themeToggle = new ToggleButton("Dark Mode", parseBoolean(IS_DARK_THEME.getDefaultValue()));
        themeToggle.addValueChangeListener(e -> setTheme(e.getValue()));

        // load theme setting and apply it to the theme toggle
        WebStorage.getItem(IS_DARK_THEME.getName(), value -> {
            var isDarkTheme = value == null
                    ? parseBoolean(IS_DARK_THEME.getDefaultValue())
                    : parseBoolean(value);
            themeToggle.setValue(isDarkTheme);
        });

        return themeToggle;
    }

    private HorizontalLayout buildGenerationRow() {
        // generations input field
        var generationsInput = new IntegerField("Generations");
        generationsInput.setValue(5);
        generationsInput.setMin(2);
        generationsInput.setMax(6);
        generationsInput.setStepButtonsVisible(true);
        generationsInput.addValueChangeListener(event -> ComponentUtil.fireEvent(UI.getCurrent(),
                new GenerationChangeEvent(generationsInput, event.getValue())));

        // expand and collapse buttons
        var expandAll = new Button("Expand All");
        expandAll.addClickListener(event -> ComponentUtil.fireEvent(UI.getCurrent(), new ExpandAllEvent(expandAll)));

        var collapseAll = new Button("Collapse All");
        collapseAll.addClickListener(event -> ComponentUtil.fireEvent(UI.getCurrent(), new CollapseAllEvent(collapseAll)));

        var generationRow = new HorizontalLayout(
                generationsInput,
                expandAll,
                collapseAll
        );
        generationRow.setAlignItems(Alignment.END);

        return generationRow;
    }

    private void setTheme(boolean isDark) {
        // save isDark setting in local storage
        WebStorage.setItem(IS_DARK_THEME.getName(), String.valueOf(isDark));

        // set theme in UI
        var js = "document.documentElement.setAttribute('theme', $0)";
        getElement().executeJs(js, isDark ? Lumo.DARK : Lumo.LIGHT);
    }
}
