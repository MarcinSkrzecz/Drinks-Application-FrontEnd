package com.kodilla.drinks_frontend.contactUs;

public class ContactUs {
    private String title;
    private String content;

    public ContactUs(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactUs contactUs = (ContactUs) o;

        if (title != null ? !title.equals(contactUs.title) : contactUs.title != null) return false;
        return content != null ? content.equals(contactUs.content) : contactUs.content == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}