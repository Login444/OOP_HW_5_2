package org.example;

import java.util.Scanner;

public class Main {
    // Создать телефонный справочник с возможностью импорта и экспорта данных в нескольких форматах.
    //под форматами понимаем структуру файлов, например:
    //* в файле на одной строке хранится одна часть записи, пустая строка - разделитель


    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println("\nМеню"
                +"\n1.Показать все контакты"
                +"\n2.Найти контакт по фамилии"
                +"\n3.Добавить контакт"
                +"\n4.Изменить контакт"
                +"\n5.Удалить контакт"
                +"\n6.Экспортировать телефонную книгу в файл"
                +"\n7.Импортировать телефонную книгу из файла"
                +"\n8.Выход");
        Scanner scan = new Scanner(System.in);
        int choose = scan.nextInt();
        while (choose != 8){
            if (choose == 1){
                phoneBook.showAllContacts();
            }
            if (choose == 2){
                PhoneBook findBy = new PhoneBook();
                findBy.searchContactByLastName();
                findBy.showAllContacts();
            }
            if (choose == 3){
                phoneBook.addContact();
            }
            if (choose == 4){
                phoneBook.editContact();
            }
            if (choose == 5){
                phoneBook.deleteContact();
            }
            if (choose == 6){
                phoneBook.toFile();
            }
            if (choose == 7){
                phoneBook.fromFile();
            }

            System.out.println("\nМеню"
                    +"\n1.Показать все контакты"
                    +"\n2.Найти контакт по фамилии"
                    +"\n3.Добавить контакт"
                    +"\n4.Изменить контакт"
                    +"\n5.Удалить контакт"
                    +"\n6.Экспортировать телефонную книгу в файл"
                    +"\n7.Импортировать телефонную книгу из файла"
                    +"\n8.Выход");
            choose = scan.nextInt();
        }
    }
}