package com.kodilla.drinks_frontend.contactUs;

import com.kodilla.drinks_frontend.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "contactUs", layout = MainLayout.class)
@PageTitle("Contact-Us")
public class ContactUsView extends VerticalLayout {

    private ContactUsForm contactUsForm = new ContactUsForm();

    public ContactUsView() {
        HorizontalLayout mainContent = new HorizontalLayout(contactUsForm);
        mainContent.setSizeFull();

        add(mainContent);
        setSizeFull();
    }
}