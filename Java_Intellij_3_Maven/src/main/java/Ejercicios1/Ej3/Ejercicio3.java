package Ejercicios1.Ej3;

import Ejercicios1.Book;
import Ejercicios1.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {

    public static void main(String[] args) {

        Library miLibreria = new Library();

        miLibreria.getLibreria().add(new Book("Libro 1","Autor 1",2000));
        miLibreria.getLibreria().add(new Book("Libro 2","Autor 2",1000));
        miLibreria.getLibreria().add(new Book("Libro 3","Autor 3",5000));
        miLibreria.getLibreria().add(new Book("Libro 4","Autor 4",8000));

        ObjectMapper objeto = new ObjectMapper();

        try (BufferedWriter escribirBufer = new BufferedWriter(new FileWriter("src/main/java/Ejercicios1/Ej3/archivo.json",true))){

            escribirBufer.write(objeto.writeValueAsString(miLibreria));
            escribirBufer.newLine();


        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }


    }

}
