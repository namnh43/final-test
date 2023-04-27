package main;

import menu.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("main process");
        Menu menu = new Menu();
        menu.display();
    }
}
