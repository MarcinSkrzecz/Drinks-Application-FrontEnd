package com.kodilla.drinks_frontend.ingredients;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class IngredientsForm extends FormLayout {
    private TextField description = new TextField("Description");
    private IntegerField howManyTimesUsed = new IntegerField("HowManyTimesUsed");
    private Binder<Ingredients> binder = new Binder<>(Ingredients.class);


    private IngredientsListView ingredientsListView;

    public IngredientsForm(IngredientsListView ingredientsListView) {
        this.ingredientsListView = ingredientsListView;

        add(description, howManyTimesUsed);

        binder.bindInstanceFields(this);
    }

    public void setIngredients(Ingredients ingredients) {
        binder.setBean(ingredients);
        if (ingredients == null) {
            setVisible(false);
        } else {
            setVisible(true);
            description.focus();
        }
    }
}
