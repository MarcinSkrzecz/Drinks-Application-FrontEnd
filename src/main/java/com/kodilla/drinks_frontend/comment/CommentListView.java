package com.kodilla.drinks_frontend.comment;

import com.kodilla.drinks_frontend.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "comment", layout = MainLayout.class)
@PageTitle("Comments")
public class CommentListView extends VerticalLayout {

    private CommentService commentService = CommentService.getInstance();
    private Grid grid = new Grid<>(Comment.class);
    private TextField filterByDrinkId = new TextField();
    private CommentForm commentForm = new CommentForm(this);
    private Button addNewComment = new Button("Add new comment");

    public CommentListView() {
        filterByDrinkId.setPlaceholder("Filter by drink id...");
        filterByDrinkId.setClearButtonVisible(true);
        filterByDrinkId.setValueChangeMode(ValueChangeMode.EAGER);
        filterByDrinkId.addValueChangeListener(e -> updateFilterByDrinkId());

        grid.setColumns("id","drinkId","username","comment","rate", "likes", "creationDate");

        addNewComment.addClickListener(e -> {
            grid.asSingleSelect().clear();
            commentForm.setComment(new Comment());
        });
        HorizontalLayout toolbar = new HorizontalLayout(filterByDrinkId, addNewComment);

        HorizontalLayout mainContent = new HorizontalLayout(grid, commentForm);
        mainContent.setSizeFull();
        grid.setSizeFull();

        add(toolbar, mainContent);
        commentForm.setComment(null);
        setSizeFull();
        refresh();

        grid.asSingleSelect().addValueChangeListener(event -> commentForm.setComment((Comment) grid.asSingleSelect().getValue()));
    }

    public void refresh() {
        grid.setItems(commentService.getComments());
    }

    public void updateFilterByDrinkId() {
        grid.setItems(commentService.findByDrinkId(filterByDrinkId.getValue()));
    }
}
