package Ejercicios1.Ej3;

import Ejercicios1.Book;
import Ejercicios1.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio3 {

    public static void main(String[] args) {

        ArrayList<Library> librerias = new ArrayList<>();

        Library miLibreria = new Library();
        Library miLibreria2 = new Library();

        miLibreria.getLibreria().add(new Book("Libro 1","Autor 1",2000));
        miLibreria.getLibreria().add(new Book("Libro 2","Autor 2",1000));
        miLibreria.getLibreria().add(new Book("Libro 3","Autor 3",5000));
        miLibreria.getLibreria().add(new Book("Libro 4","Autor 4",8000));

        miLibreria2.getLibreria().add(new Book("Libro 10","Autor 10",2000));
        miLibreria2.getLibreria().add(new Book("Libro 20","Autor 20",1000));
        miLibreria2.getLibreria().add(new Book("Libro 30","Autor 30",5000));
        miLibreria2.getLibreria().add(new Book("Libro 40","Autor 40",8000));

        librerias.add(miLibreria);
        librerias.add(miLibreria2);

        ObjectMapper objeto = new ObjectMapper();

        try {

            objeto.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/Ejercicios1/Ej3/archivo.json"), librerias);

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }


    }

}
