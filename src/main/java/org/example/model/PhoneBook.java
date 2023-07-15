package org.example.model;



import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    public List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<Contact>();
    }


    public List<Contact> getContacts() {
        return contacts;
    }

}
