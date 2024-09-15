package com.alura.conversorDeMoneda.Moduls;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner lectura = new Scanner(System.in);

    private int opcion;
    private boolean validacion=true;
    private int cantidad;
    private double valor;

    private String uri;
    private String menuOpciones = """
            *****Conversor de Moneda******
            1) Dólar =>> Peso argentino\n
            2) Peso argentino =>> Dólar\n
            3) Dólar =>> Real brasileño\n
            4) Real brasileño =>> Dólar\n
            5) Dólar =>> Peso colombiano\n
            6) Peso colombiano =>> Dólar\n
            7) Salir\n
            """;

    public Menu() throws IOException, InterruptedException {
    }

    private String getMenuOpciones() {
        return menuOpciones;
    }

    public void elegir() throws IOException, InterruptedException {
        while (validacion){
            System.out.println(getMenuOpciones());
            System.out.println("Elija una opción válida: ");
            opcion = lectura.nextInt();
            System.out.println("*************************");
            options(opcion);
        }
    }

    private void options(int opcion) throws IOException, InterruptedException {
        switch (opcion) {
            case 1:
                UsdToArs();
                System.out.println("*************************");
                break;
            case 2:
                ArsToUsd();
                System.out.println("*************************");
                break;
            case 3:
                UsdToBrl();
                System.out.println("*************************");
                break;
            case 4:
                BrlToUsd();
                System.out.println("*************************");
                break;
            case 5:
                UsdToCop();
                System.out.println("*************************");
                break;
            case 6:
               CopToUsd();
                System.out.println("*************************");
                break;
            case 7:
                System.out.println("*************************");
                System.out.println("Fuera del sistema");
                validacion=false;
                break;
            default:
                System.out.println("*************************");
                System.out.println("La opcion: "+ opcion+" no existe");
                validacion=false;
                break;
        }
    }

  private void setUri(String currencyAfter, String currencyBefore, int cantidad){
        this.uri="https://v6.exchangerate-api.com/v6/7fcbc64dd363d62240e31d4b/pair/"+currencyAfter+"/"+currencyBefore+"/"+cantidad;
  }

    private double consultarApi(String uri)throws  IOException, InterruptedException{
        ConsultaApi api = new ConsultaApi(uri);
         return api.getData();
    }
    private void UsdToArs() {

        try {
            System.out.println("Ingrese el valor que deseas convertir: ");
            cantidad = lectura.nextInt();
            setUri("USD", "ARS", cantidad);
            valor = consultarApi(uri);
            System.out.println("El valor "+(double) cantidad +" [USD] " + "corresponde al valor final de =>> "+valor+ " [ARS]");
        } catch (Exception e){
            throw new RuntimeException(e);
        }


    }

    private void ArsToUsd() throws IOException, InterruptedException {
        try {
            System.out.println("Ingrese el valor que deseas convertir: ");
            cantidad = lectura.nextInt();
            setUri("ARS", "USD", cantidad);
            valor = consultarApi(uri);
            System.out.println("El valor "+(double) cantidad +" [ARS] " + "corresponde al valor final de =>> "+valor+ " [USD]");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void UsdToBrl() throws IOException, InterruptedException {
        try {
            System.out.println("Ingrese el valor que deseas convertir: ");
            cantidad = lectura.nextInt();
            setUri("USD", "BRL", cantidad);
            valor = consultarApi(uri);
            System.out.println("El valor "+(double) cantidad +" [USD] " + "corresponde al valor final de =>> "+valor+ " [BRL]");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private  void BrlToUsd(){
        try{
            System.out.println("Ingrese el valor que deseas convertir: ");
            cantidad = lectura.nextInt();
            setUri("BRL", "USD", cantidad);
            valor = consultarApi(uri);
            System.out.println("El valor "+(double) cantidad +" [BRL] " + "corresponde al valor final de =>> "+valor+ " [USD]");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void UsdToCop(){
        try{
            System.out.println("Ingrese el valor que deseas convertir: ");
            cantidad = lectura.nextInt();
            setUri("USD", "COP", cantidad);
            valor = consultarApi(uri);
            System.out.println("El valor "+(double) cantidad +" [USD] " + "corresponde al valor final de =>> "+valor+ " [COP]");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private  void  CopToUsd(){
        try{
            System.out.println("Ingrese el valor que deseas convertir: ");
            cantidad = lectura.nextInt();
            setUri("COP", "USD", cantidad);
            valor = consultarApi(uri);
            System.out.println("El valor "+(double) cantidad +" [COP] " + "corresponde al valor final de =>> "+valor+ " [USD]");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
