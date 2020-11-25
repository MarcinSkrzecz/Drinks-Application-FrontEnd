package com.kodilla.drinks_frontend.RPProposedIngredients;

import com.kodilla.drinks_frontend.votedIngredients.Votes;
import com.kodilla.drinks_frontend.votedIngredients.VotesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class RPForm extends FormLayout {
    private TextField ingredient = new TextField("Ingredient");

    private Button vote = new Button("Propose Your or take from list");

    private Binder<RPIngredients> binder = new Binder<>(RPIngredients.class);

    private RPListView rpListView;
    private RPService rpService = RPService.getInstance();
    private VotesService votesService = VotesService.getInstance();

    public RPForm(RPListView rpListView) {

        this.rpListView = rpListView;

        HorizontalLayout buttons = new HorizontalLayout(vote);
        vote.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        vote.addClickListener(event -> vote());

        add(ingredient, buttons);

        binder.bindInstanceFields(this);
    }

    private void vote() {
        RPIngredients rpIngredients = binder.getBean();

        String ingredient = rpIngredients.getIngredient();
        votesService.vote(new Votes());
        rpListView.refresh();
        setRPIngredient(null);
    }

    public void setRPIngredient(RPIngredients rpIngredient) {
        binder.setBean(rpIngredient);
        if (rpIngredient == null) {
            setVisible(false);
        } else {
            setVisible(true);
            ingredient.focus();
        }
    }
}
