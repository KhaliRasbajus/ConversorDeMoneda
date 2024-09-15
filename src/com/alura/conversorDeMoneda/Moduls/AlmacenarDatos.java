package com.alura.conversorDeMoneda.Moduls;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlmacenarDatos {



    List<String> datosList = new ArrayList<>();
    FileWriter escritura;
    {
        try {
            escritura = new FileWriter("historialDeConverciones.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void setDatosList(String message) {
        datosList.add(message);
    }

    public  void getDatosList(){
        try{

            for(String data: datosList){
                    System.out.println(data);

                    escritura.write(data);
            }
            escritura.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
