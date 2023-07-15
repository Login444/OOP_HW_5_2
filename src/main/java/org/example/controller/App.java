package org.example.controller;

import org.example.view.View;
import org.example.model.Model;

public class App {
    public static void mainMenu(){
        View view = new Input();
        Model model = new Model(view);
        System.out.println("\nМеню"
                +"\n1.Показать все контакты"
                +"\n2.Найти контакт по фамилии"
                +"\n3.Добавить контакт"
                +"\n4.Изменить контакт"
                +"\n5.Удалить контакт"
                +"\n6.Экспортировать телефонную книгу в файл"
                +"\n7.Импортировать телефонную книгу из файла"
                +"\n8.Выход");
        int choose = view.chooseMenuButton();
        while (choose != 8){
            if (choose == 1){
                model.showAllContacts();
            }
            if (choose == 2){
                Model findBy = new Model(view);
                findBy.searchContactByLastName();
                findBy.showAllContacts();
            }
            if (choose == 3){
                model.addContact();
            }
            if (choose == 4){
                model.editContact();
            }
            if (choose == 5){
                model.deleteContact();
            }
            if (choose == 6){
                model.toFile();
            }
            if (choose == 7){
                model.fromFile();
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
            choose = view.chooseMenuButton();
        }
    }
}
