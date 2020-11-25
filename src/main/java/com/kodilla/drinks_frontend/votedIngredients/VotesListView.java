package com.kodilla.drinks_frontend.votedIngredients;

import com.kodilla.drinks_frontend.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "votes", layout = MainLayout.class)
@PageTitle("Votes List | Vote")
public class VotesListView extends VerticalLayout {

    private VotesService votesService = VotesService.getInstance();
    private Grid grid = new Grid<>(Votes.class);
    private TextField filterByIngredient = new TextField();
    private VotesForm votesForm = new VotesForm(this);
    private Button vote = new Button("Vote");

    public VotesListView() {
        filterByIngredient.setPlaceholder("Filter by ingredient...");
        filterByIngredient.setClearButtonVisible(true);
        filterByIngredient.setValueChangeMode(ValueChangeMode.EAGER);
        filterByIngredient.addValueChangeListener(e -> updateFilterByIngredient());

        grid.setColumns("id","ingredient","votesCount");
//tutaj
        vote.addClickListener(e -> {
            grid.asSingleSelect().clear();
            votesForm.setVote(new Votes());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filterByIngredient, vote);
//tutaj
        HorizontalLayout mainContent = new HorizontalLayout(grid, votesForm);
        mainContent.setSizeFull();
        grid.setSizeFull();
//tutaj
        add(toolbar, mainContent);
        votesForm.setVote(null);
        setSizeFull();
        refresh();
//tutaj
        grid.asSingleSelect().addValueChangeListener(event -> votesForm.setVote((Votes) grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(votesService.getVotes());
    }

    public void updateFilterByIngredient() {
        grid.setItems(votesService.findByIngredient(filterByIngredient.getValue()));
    }
}
