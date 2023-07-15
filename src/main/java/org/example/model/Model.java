package org.example.model;

import org.example.view.View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Model {
    PhoneBook currentBook = new PhoneBook();
    private View view;

    public Model(View view) {
        this.view = view;
    }

    public PhoneBook currentBook(){
        return this.currentBook;
    }

    public void toFile() {
        File newFile = new File("phone_book.txt");
        try (FileWriter writer = new FileWriter(newFile, true)) {
            for (Contact contact : currentBook.getContacts()) {
                String text = contact.toString();
                writer.write(text + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fromFile() {
        try (FileReader fileReader = new FileReader("phone_book.txt")) {

            BufferedReader reader = new BufferedReader(fileReader);
            while (reader.ready()){
                Contact expContact = new Contact();
                String line = reader.readLine();
                String[] lineToArray = line.split("\s");
                String lastName = lineToArray[0];
                expContact.setLastName(lastName);
                String name = lineToArray[1];
                expContact.setName(name);
                String phoneNumber = lineToArray[2];
                expContact.setPhoneNumber(phoneNumber);
                currentBook.getContacts().add(expContact);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchContactByLastName(){
        System.out.println("Введите фамилию искомого контакта:");
        String find = view.getLastName();
        List<Contact> searchRes = new ArrayList<>();
        for (Contact contact : currentBook.getContacts()) {
            if (contact.getLastName().toLowerCase() == find.toLowerCase()){
                searchRes.add(contact);
            }
        }
        for (Contact searchRe : searchRes) {
            System.out.println(searchRe);
        }
    }

    public void deleteContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Номер контакта для удаления:");
        int find = view.chooseContactNum();
        currentBook.getContacts().remove(find-1);
    }

    public void showAllContacts(){
        int i = 1;
        for (Contact contact : currentBook().getContacts()) {
            System.out.println(i + ". "+ contact);
            i++;
        }
    }

    public void editContact(){
        System.out.println("Номер контакта для изменения:");
        int find = view.chooseContactNum();
        System.out.println("Что изменить?"
                +"\n1.Фамилию"
                +"\n2.Имя"
                +"\n3.Телефон");
        int n = view.chooseMenuButton();
        switch (n){
            case 1:
                currentBook.getContacts().get(find-1).setLastName(view.getLastName());
                break;
            case 2:
                currentBook.getContacts().get(find-1).setName(view.getName());
                break;
            case 3:
                currentBook.getContacts().get(find-1).setPhoneNumber(view.getPhoneNumber());
                break;
        }

    }

    public void addContact(){
        Contact newContact = new Contact();
        newContact.setLastName(view.getLastName());
        newContact.setName(view.getName());
        newContact.setPhoneNumber(view.getPhoneNumber());
        currentBook.getContacts().add(newContact);
    }


}
