package com.kodilla.drinks_frontend.ingredients;

import com.kodilla.drinks_frontend.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "ingredients", layout = MainLayout.class)
@PageTitle("Ingredients")
public class IngredientsListView extends VerticalLayout {

    private IngredientsService ingredientsService = IngredientsService.getInstance();
    private Grid grid = new Grid<>(Ingredients.class);
    private TextField filterByDescription = new TextField();
    private IngredientsForm ingredientsForm = new IngredientsForm(this);

    public IngredientsListView() {
        filterByDescription.setPlaceholder("Filter by description...");
        filterByDescription.setClearButtonVisible(true);
        filterByDescription.setValueChangeMode(ValueChangeMode.EAGER);
        filterByDescription.addValueChangeListener(e -> updateFilterByDescription());

        grid.setColumns("ingredientId","description","howManyTimesUsed");


        HorizontalLayout toolbar = new HorizontalLayout(filterByDescription);

        HorizontalLayout mainContent = new HorizontalLayout(grid, ingredientsForm);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        ingredientsForm.setIngredients(null);
        setSizeFull();
        refresh();

        grid.asSingleSelect().addValueChangeListener(event -> ingredientsForm.setIngredients((Ingredients) grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(ingredientsService.getIngredients());
    }

    public void updateFilterByDescription() {
        grid.setItems(ingredientsService.findByDescription(filterByDescription.getValue()));
    }
}
