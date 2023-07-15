package org.example;

import java.util.Scanner;

public class Contact {
    private String lastName;
    private String name;
    private String phoneNumber;

    public Contact(String lastName, String name, String phoneNumber) {
        this.lastName = lastName;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return lastName + " " +
                name + " " +
                phoneNumber;
    }

    public Contact createContact(){
        Scanner scanner = new Scanner(System.in);
        Contact newContact = new Contact();
        System.out.println("Введите фамилию:");
        newContact.setLastName(scanner.next());
        System.out.println("Введите имя:");
        newContact.setName(scanner.next());
        System.out.println("Введите телефон:");
        newContact.setPhoneNumber(scanner.next());
        return newContact;
    }
}
