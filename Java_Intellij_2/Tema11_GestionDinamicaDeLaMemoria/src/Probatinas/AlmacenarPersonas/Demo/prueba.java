package Probatinas.AlmacenarPersonas.Demo;

import Probatinas.AlmacenarPersonas.Clases.Persona;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class prueba {

    public static void main(String[] args) {

        ArrayList<Persona> personas = new ArrayList<>();

        personas.add(new Persona("131232965R","Pepe","Martínez",33,"Hombre",false, Date.valueOf("2000-01-01")));
        personas.add(new Persona("º123131312S","Loli","González",22,"Mujer",true, Date.valueOf("2025-01-01")));
        personas.add(new Persona("131232965R","Pepe","Martínez",33,"Hombre",false, Date.valueOf("2025-01-01")));
        personas.add(new Persona("131232965R","Pepe","Martínez",33,"Hombre",false, Date.valueOf("2025-01-01")));


        try (BufferedWriter escribirBufer  = new BufferedWriter(new FileWriter("probatinas/personas.txt"))) {





        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
