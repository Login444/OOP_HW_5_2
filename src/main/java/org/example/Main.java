package org.example;

import java.util.Arrays;

public class Main {
    // Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах.
    //под форматами понимаем структуру файлов, например:
    //* в файле на одной строке хранится одна часть записи, пустая строка - разделитель


    public static void main(String[] args) {
        PhoneBook contacts = new PhoneBook();
        contacts.addContact();
        // contacts.toFile();
        // contacts.fromFile();

    }


}