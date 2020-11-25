package com.kodilla.drinks_frontend;

import com.kodilla.drinks_frontend.RPProposedIngredients.RPListView;
import com.kodilla.drinks_frontend.comment.CommentListView;
import com.kodilla.drinks_frontend.contactUs.ContactUsView;
import com.kodilla.drinks_frontend.drink.DrinkListView;
import com.kodilla.drinks_frontend.ingredients.IngredientsListView;
import com.kodilla.drinks_frontend.votedIngredients.VotesListView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Drinks Application");
        logo.addClassName("logo");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.addClassName("header");
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("Drinks List", DrinkListView.class);
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                listLink,
                new RouterLink("All Comments", CommentListView.class),
                new RouterLink("Ingredients List", IngredientsListView.class),
                new RouterLink("Ingredients Proposed by us", RPListView.class),
                new RouterLink("Voted Ingredients", VotesListView.class),
                new RouterLink("Contact Us", ContactUsView.class)
        ));
    }
}


















