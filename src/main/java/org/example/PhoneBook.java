package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook implements ImpExp{
    public List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<Contact>();
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
                contacts.add(expContact);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addContact(){
        Scanner scanner = new Scanner(System.in);
        Contact newContact = new Contact();
        System.out.println("Введите фамилию:");
        newContact.setLastName(scanner.next());
        System.out.println("Введите имя:");
        newContact.setName(scanner.next());
        System.out.println("Введите телефон:");
        newContact.setPhoneNumber(scanner.next());
        contacts.add(newContact);
    }

    public void searchContactByLastName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию искомого контакта:");
        String find = scanner.nextLine();
        List<Contact> searchRes = new ArrayList<>();
        for (Contact contact : contacts) {
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
        int find = scanner.nextInt();
        contacts.remove(find-1);
    }

    public void showAllContacts(){
        int i = 1;
        for (Contact contact : contacts) {
            System.out.println(i + ". "+ contact);
            i++;
        }
    }

    public void editContact(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Номер контакта для изменения:");
        int find = scanner.nextInt();
        System.out.println("Что изменить?"
                        +"\n1.Фамилию"
                        +"\n2.Имя"
                        +"\n3.Телефон");
        int n = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        switch (n){
            case 1:
                System.out.println("Введите новую фамилию:");
                contacts.get(find-1).setLastName(scanner1.nextLine());
                break;
            case 2:
                 System.out.println("Введите новое имя:");
                 contacts.get(find-1).setName(scanner1.nextLine());
                 break;
            case 3:
                 System.out.println("Введите новый телефон:");
                 contacts.get(find-1).setPhoneNumber(scanner1.nextLine());
                 break;
                }

        }





}
