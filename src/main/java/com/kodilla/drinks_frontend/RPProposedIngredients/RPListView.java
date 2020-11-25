package com.kodilla.drinks_frontend.RPProposedIngredients;

import com.kodilla.drinks_frontend.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "RpIngredients", layout = MainLayout.class)
@PageTitle("RP Ingredients List | Vote")
public class RPListView extends VerticalLayout {

    private RPService rpService = RPService.getInstance();
    private Grid grid = new Grid<>(RPIngredients.class);
    private TextField filterByIngredient = new TextField();
    private RPForm rpForm = new RPForm(this);
    private Button proposeIngredient = new Button("Propose/Vote Ingredient");

    public RPListView() {
        filterByIngredient.setPlaceholder("Filter by ingredient...");
        filterByIngredient.setClearButtonVisible(true);
        filterByIngredient.setValueChangeMode(ValueChangeMode.EAGER);
        filterByIngredient.addValueChangeListener(e -> updateFilterByIngredient());

        grid.setColumns("ingredient");

        proposeIngredient.addClickListener(e -> {
            grid.asSingleSelect().clear();
            rpForm.setRPIngredient(new RPIngredients());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterByIngredient, proposeIngredient);

        HorizontalLayout mainContent = new HorizontalLayout(grid, rpForm);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        rpForm.setRPIngredient(null);
        setSizeFull();
        refresh();

        grid.asSingleSelect().addValueChangeListener(event -> rpForm.setRPIngredient((RPIngredients) grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(rpService.getIngredients());
    }

    public void updateFilterByIngredient() {
        grid.setItems(rpService.findByIngredient(filterByIngredient.getValue()));
    }

}
