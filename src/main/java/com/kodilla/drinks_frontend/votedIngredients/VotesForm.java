package com.kodilla.drinks_frontend.votedIngredients;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class VotesForm extends FormLayout {
    private TextField ingredient = new TextField("Ingredient");

    private Button vote = new Button("Vote");

    private Binder<Votes> binder = new Binder<>(Votes.class);

    private VotesListView votesListView;
    private VotesService votesService = VotesService.getInstance();

    public VotesForm(VotesListView votesListView) {

        this.votesListView = votesListView;

        HorizontalLayout buttons = new HorizontalLayout(vote);
        vote.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        vote.addClickListener(event -> vote());

        add(ingredient, buttons);

        binder.bindInstanceFields(this);
    }

    private void vote() {
        Votes votes = binder.getBean();
        votesService.vote(votes);
        votesListView.refresh();
        setVote(null);
    }

    public void setVote(Votes vote) {
        binder.setBean(vote);
        if (vote == null) {
            setVisible(false);
        } else {
            setVisible(true);
            ingredient.focus();
        }
    }
}
