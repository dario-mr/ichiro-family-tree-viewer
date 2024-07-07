package com.dario.iftv.view;

import com.dario.iftv.event.CollapseAllEvent;
import com.dario.iftv.event.ExpandAllEvent;
import com.dario.iftv.event.GenerationChangeEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.WebStorage;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.theme.lumo.Lumo;

import static com.dario.iftv.core.domain.Setting.IS_DARK_THEME;
import static com.vaadin.flow.component.Unit.EM;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.END;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN;
import static java.lang.Boolean.parseBoolean;

public class FamilyTreeHeader extends VerticalLayout {

    public FamilyTreeHeader() {
        setPadding(false);
        add(buildTitleRow(), buildGenerationRow());
    }

    private HorizontalLayout buildTitleRow() {
        // title
        var title = new H2("Ichiro Family Tree");
        title.addClassName("headline");

        // theme icons
        var sunIcon = VaadinIcon.SUN_O.create();
        var moonIcon = VaadinIcon.MOON_O.create();
        configureThemeIcons(sunIcon, moonIcon);

        var titleRow = new HorizontalLayout(title, sunIcon, moonIcon);
        titleRow.setWidthFull();
        titleRow.setAlignItems(CENTER);
        titleRow.setJustifyContentMode(BETWEEN);

        return titleRow;
    }

    private void configureThemeIcons(Icon sunIcon, Icon moonIcon) {
        // by default, hide both icons
        sunIcon.setVisible(false);
        moonIcon.setVisible(false);

        // add listeners to switch theme
        sunIcon.addClickListener(e -> {
            sunIcon.setVisible(false);
            moonIcon.setVisible(true);
            setTheme(true);
        });
        moonIcon.addClickListener(e -> {
            sunIcon.setVisible(true);
            moonIcon.setVisible(false);
            setTheme(false);
        });

        // load theme setting and show the right theme icon
        WebStorage.getItem(IS_DARK_THEME.getName(), value -> {
            var isDarkTheme = value == null
                    ? parseBoolean(IS_DARK_THEME.getDefaultValue())
                    : parseBoolean(value);
            if (isDarkTheme) {
                sunIcon.setVisible(false);
                moonIcon.setVisible(true);
            } else {
                sunIcon.setVisible(true);
                moonIcon.setVisible(false);
            }
        });
    }

    private HorizontalLayout buildGenerationRow() {
        // generations input field
        var generationsInput = new IntegerField("Generations");
        generationsInput.setWidth(8, EM);
        generationsInput.setValue(5);
        generationsInput.setMin(2);
        generationsInput.setMax(6);
        generationsInput.setStepButtonsVisible(true);
        generationsInput.addValueChangeListener(event -> ComponentUtil.fireEvent(UI.getCurrent(),
                new GenerationChangeEvent(generationsInput, event.getValue())));

        // expand and collapse buttons
        var expandAll = new Button("Expand All");
        var collapseAll = new Button("Collapse All");
        collapseAll.setVisible(false);

        expandAll.addClickListener(event -> {
            expandAll.setVisible(false);
            collapseAll.setVisible(true);
            ComponentUtil.fireEvent(UI.getCurrent(), new ExpandAllEvent(expandAll));
        });
        collapseAll.addClickListener(event -> {
            expandAll.setVisible(true);
            collapseAll.setVisible(false);
            ComponentUtil.fireEvent(UI.getCurrent(), new CollapseAllEvent(collapseAll));
        });

        var generationRow = new HorizontalLayout(
                generationsInput,
                expandAll,
                collapseAll
        );
        generationRow.setAlignItems(END);

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
