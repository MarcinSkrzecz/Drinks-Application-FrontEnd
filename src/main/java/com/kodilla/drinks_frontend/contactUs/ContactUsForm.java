package com.kodilla.drinks_frontend.contactUs;


import com.kodilla.drinks_frontend.connectionsToBackend.ContactUsConnections;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class ContactUsForm extends FormLayout {

    @Autowired
    private ContactUsConnections contactUsConnections;

    private TextField title = new TextField("Title");
    private TextField content = new TextField("Content");

    private Button sendMessage = new Button("Send Message");

    public ContactUsForm() {
        HorizontalLayout button = new HorizontalLayout(sendMessage);
        sendMessage.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        String messageTitle = title.getValue();
        String messageContent = content.getValue();

        sendMessage.addClickListener(event -> send(new ContactUs(messageTitle, messageContent)));

        add(title, content, button);
    }

    private void send(ContactUs contactUs) {
        System.out.println("send message - title: " + contactUs.getTitle() + ", content: " + contactUs.getContent());
        //Backend - Not working
        //contactUsConnections.contactUs(contactUs);
        setContactUs(null);
    }

    public void setContactUs(ContactUs contactUs) {
        if (contactUs == null) {
            setVisible(false);
        } else {
            setVisible(true);
        }
    }
}
