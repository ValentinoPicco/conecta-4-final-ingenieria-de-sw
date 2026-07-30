package com.conecta4.ui;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements UI{
    Scanner scanner;

    public ConsoleUI(Scanner sc){
        scanner = sc;
    }

    // mejorables
    @Override
    public int intRequest() {
        return scanner.nextInt();
    }

    @Override
    public String tokenRequest() {
        return scanner.next();
    }

    @Override
    public void show(String print) {
        System.out.println(print);
    }

    @Override
    public void showList(List<String> tokens) {
        int i = 1;
        for (String token : tokens) {
            System.out.println(i + ". " + token);
        }
        i++;
    }
}
