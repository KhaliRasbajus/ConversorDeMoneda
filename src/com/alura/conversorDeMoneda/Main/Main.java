package com.alura.conversorDeMoneda.Main;

import com.alura.conversorDeMoneda.Moduls.Menu;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        menu.elegir();
    }

}
