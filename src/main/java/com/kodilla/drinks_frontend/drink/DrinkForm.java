package com.kodilla.drinks_frontend.drink;

import com.kodilla.drinks_frontend.comment.CommentListView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.RouterLink;

public class DrinkForm extends FormLayout {
    private TextField username = new TextField("Username");
    private TextField drinkName = new TextField("DrinkName");
    private TextField recipe = new TextField("Recipe");
    private TextField ingredients = new TextField("Ingredients");

    private Button save = new Button("Save");
    private Button update = new Button("Update");
    private Button delete = new Button("Delete");
    private RouterLink viewComments = new RouterLink("View Comments", CommentListView.class);

    private Binder<Drink> binder = new Binder<>(Drink.class);

    private DrinkListView drinkListView;
    private DrinkService drinkService = DrinkService.getInstance();

    public DrinkForm(DrinkListView drinkListView) {

        this.drinkListView = drinkListView;

        HorizontalLayout buttons = new HorizontalLayout(save, update, delete, viewComments);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        save.addClickListener(event -> save());
        update.addClickListener(event -> update());
        delete.addClickListener(event -> delete());

        add(username, drinkName, recipe, ingredients, buttons);

        binder.bindInstanceFields(this);
    }

    private void save() {
        Drink drink = binder.getBean();
        drinkService.save(drink);
        drinkListView.refresh();
        setDrink(null);
    }

    private void update() {
        Drink drink = binder.getBean();
        drinkService.update(drink);
        drinkListView.refresh();
        setDrink(null);
    }

    private void delete() {
        Drink drink = binder.getBean();
        drinkService.delete(drink);
        drinkListView.refresh();
        setDrink(null);
    }

    public void setDrink(Drink drink) {
        binder.setBean(drink);
        if (drink == null) {
            setVisible(false);
        } else {
            setVisible(true);
            drinkName.focus();
        }
    }
}
