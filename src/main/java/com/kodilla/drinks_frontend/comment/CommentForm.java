package com.kodilla.drinks_frontend.comment;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CommentForm extends FormLayout {

    private IntegerField drinkId = new IntegerField("DrinkId");
    private TextField username = new TextField("UserName");
    private TextField comment = new TextField("Comment");
    private IntegerField rate = new IntegerField("Rate");

    private Button save = new Button("Save");
    private Button update = new Button("Update");
    private Button delete = new Button("Delete");
    private Button like = new Button("Like");

    private Binder<Comment> binder = new Binder<>(Comment.class);

    private CommentListView commentListView;
    private CommentService commentService = CommentService.getInstance();

    public CommentForm(CommentListView commentListView) {
        this.commentListView = commentListView;

        HorizontalLayout buttons = new HorizontalLayout(save, update, delete, like);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        save.addClickListener(event -> save());
        update.addClickListener(event -> update());
        delete.addClickListener(event -> delete());
        like.addClickListener(event -> like());

        add(drinkId, username, comment, rate, buttons);

        binder.bindInstanceFields(this);
    }

    private void save() {
        Comment comment = binder.getBean();
        commentService.save(comment);
        commentListView.refresh();
        setComment(null);
    }
    private void update() {
        Comment comment = binder.getBean();
        commentService.update(comment);
        commentListView.refresh();
        setComment(null);
    }

    private void delete() {
        Comment comment = binder.getBean();
        commentService.delete(comment);
        commentListView.refresh();
        setComment(null);
    }

    private void like() {
        Comment comment = binder.getBean();
        commentService.like(comment);
        commentListView.refresh();
        setComment(null);
    }

    public void setComment(Comment comment) {
        binder.setBean(comment);
        if (comment == null) {
            setVisible(false);
        } else {
            setVisible(true);
            drinkId.focus();
        }
    }
}