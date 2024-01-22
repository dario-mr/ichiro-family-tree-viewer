package com.dario.iftv.view;

import com.dario.iftv.core.domain.Dog;
import com.vaadin.componentfactory.ToggleButton;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.WebStorage;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.data.provider.hierarchy.TreeDataProvider;
import com.vaadin.flow.theme.lumo.Lumo;

import java.util.List;
import java.util.function.Function;

import static com.dario.iftv.core.domain.Setting.IS_DARK_THEME;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.MAX_VALUE;

public class FamilyTreeHeader extends VerticalLayout {

    public FamilyTreeHeader(TreeGrid<Dog> dogGrid, Function<Integer, Void> updateTreeFunction) {
        setPadding(false);

        var titleRow = buildTitleRow();
        var generationRow = buildGenerationRow(dogGrid, updateTreeFunction);

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

    private static HorizontalLayout buildGenerationRow(TreeGrid<Dog> dogGrid, Function<Integer, Void> updateTreeFunction) {
        // generations input field
        var generationsInput = new IntegerField("Generations", 5, event -> updateTreeFunction.apply(event.getValue()));
        generationsInput.setMin(2);
        generationsInput.setMax(6);
        generationsInput.setStepButtonsVisible(true);

        // expand and collapse buttons
        var generationRow = new HorizontalLayout(
                generationsInput,
                new Button("Expand All", event -> dogGrid.expandRecursively(getRootDog(dogGrid), MAX_VALUE)),
                new Button("Collapse All", event -> dogGrid.collapseRecursively(getRootDog(dogGrid), MAX_VALUE))
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

    private static List<Dog> getRootDog(TreeGrid<Dog> dogGrid) {
        return ((TreeDataProvider<Dog>) dogGrid.getDataProvider()).getTreeData().getRootItems();
    }
}
