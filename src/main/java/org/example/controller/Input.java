package org.example.controller;

import org.example.view.View;

import java.util.Scanner;

public class Input implements View {
    Scanner stringIn;
    Scanner integerIn;
    public Input(){
        stringIn = new Scanner(System.in);
        integerIn = new Scanner(System.in);
    }


    @Override
    public String getLastName() {
        System.out.println("Введите фамилию:");
        return stringIn.nextLine();
    }

    @Override
    public String getName() {
        System.out.println("Введите имя:");
        return stringIn.nextLine();
    }

    @Override
    public String getPhoneNumber() {
        System.out.println("Введите номер:");
        return stringIn.nextLine();
    }

    @Override
    public Integer chooseMenuButton() {
        System.out.println("Выберите пункт меню:");
        return integerIn.nextInt();
    }

    @Override
    public Integer chooseContactNum() {
        System.out.println("Выберите номер контакта:");
        return integerIn.nextInt();
    }


}
