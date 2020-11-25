package com.kodilla.drinks_frontend.drink;

import com.kodilla.drinks_frontend.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Drinks")
public class DrinkListView extends VerticalLayout {

    private DrinkService drinkService = DrinkService.getInstance();
    private Grid grid = new Grid<>(Drink.class);
    private TextField filterByName = new TextField();
    private TextField filterByFirstIngredient = new TextField();
    private TextField filterBySecondIngredient = new TextField();
    private DrinkForm drinkForm = new DrinkForm(this);
    private Button addNewDrink = new Button("Add new drink");

    public DrinkListView() {
        filterByName.setPlaceholder("Filter by name...");
        filterByName.setClearButtonVisible(true);
        filterByName.setValueChangeMode(ValueChangeMode.EAGER);
        filterByName.addValueChangeListener(e -> updateFilterByName());
        filterByFirstIngredient.setPlaceholder("Filter by 1st ingredient...");
        filterByFirstIngredient.setClearButtonVisible(true);
        filterByFirstIngredient.setValueChangeMode(ValueChangeMode.EAGER);
        filterByFirstIngredient.addValueChangeListener(e -> updateFilterByFirstIngredient());
        filterBySecondIngredient.setPlaceholder("Filter by 2nd ingredient...");
        filterBySecondIngredient.setClearButtonVisible(true);
        filterBySecondIngredient.setValueChangeMode(ValueChangeMode.EAGER);
        filterBySecondIngredient.addValueChangeListener(e -> updateFilterBySecondIngredient());

        grid.setColumns("id","username","drinkName","recipe","ingredients", "creationDate");
//tutaj
        addNewDrink.addClickListener(e -> {
            grid.asSingleSelect().clear();
            drinkForm.setDrink(new Drink());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterByName, filterByFirstIngredient, filterBySecondIngredient, addNewDrink);
//tutaj
        HorizontalLayout mainContent = new HorizontalLayout(grid, drinkForm);
        mainContent.setSizeFull();
        grid.setSizeFull();
//tutaj
        add(toolbar, mainContent);
        drinkForm.setDrink(null);
        setSizeFull();
        refresh();
//tutaj
        grid.asSingleSelect().addValueChangeListener(event -> drinkForm.setDrink((Drink) grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(drinkService.getDrinks());
    }

    public void updateFilterByName() {
        grid.setItems(drinkService.findByName(filterByName.getValue()));
    }

    public void updateFilterByFirstIngredient() {
        grid.setItems(drinkService.filterByFirstIngredient(filterByFirstIngredient.getValue()));
    }
    public void updateFilterBySecondIngredient() {
        grid.setItems(drinkService.filterBySecondIngredient(filterByFirstIngredient.getValue(),filterBySecondIngredient.getValue()));
    }
}
