package com.dario.iftv.view;

import com.dario.iftv.core.service.FamilyTreeService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

import static com.dario.iftv.core.domain.AppCookie.IS_DARK_THEME;
import static com.dario.iftv.util.CookieUtil.getCookie;
import static java.lang.Boolean.parseBoolean;

@Route
@PageTitle("Ichiro Family Tree")
@RequiredArgsConstructor
public class MainView extends VerticalLayout {

    private final FamilyTreeService familyTreeService;

    @PostConstruct
    public void init() {
        setHeightFull();
        setTheme();

        var familyTreeGrid = new FamilyTreeGrid();

        Function<Integer, Void> updateTreeFunction = generations -> {
            familyTreeGrid.setRootDog(familyTreeService.getDog("Ichiro Go Takimisou", generations));
            return null;
        };

        updateTreeFunction.apply(5);    // by default, load 5 generations

        var header = new FamilyTreeHeader(familyTreeGrid, updateTreeFunction);

        add(header, familyTreeGrid);
    }

    private void setTheme() {
        var isDarkTheme = parseBoolean(getCookie(IS_DARK_THEME));
        var js = "document.documentElement.setAttribute('theme', $0)";

        getElement().executeJs(js, isDarkTheme ? Lumo.DARK : Lumo.LIGHT);
    }
}
