package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook implements ImpExp{
    public List<Contact> contacts = new ArrayList<>();

    public PhoneBook(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public PhoneBook() {
    }


    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
    @Override
    public void toFile() {
        File newFile = new File("phone_book.txt");
        try (FileWriter writer = new FileWriter(newFile, true)) {
            for (Contact contact : contacts) {
                String text = contact.toString();
                writer.write(text + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fromFile() {
        List<String> newContacts = new ArrayList<>();
        try (FileReader fileReader = new FileReader("phone_book.txt")) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null){
                newContacts.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String newContact : newContacts) {
            System.out.println(newContact);
        }
    }

    public void addContact(){
        Scanner scanner = new Scanner(System.in);
        Contact newContact = new Contact();
        System.out.println("Фамилия:");
        newContact.setLastName(scanner.next());
        System.out.println("Имя:");
        newContact.setName(scanner.next());
        System.out.println("Телефон:");
        newContact.setPhoneNumber(scanner.next());
        scanner.close();
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "contacts=" + contacts +
                '}';
    }

}
