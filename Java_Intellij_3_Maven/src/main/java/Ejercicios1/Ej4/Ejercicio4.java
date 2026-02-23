package Ejercicios1.Ej4;

import Ejercicios1.Book;
import Ejercicios1.Library;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio4 {

    public static void main(String[] args) {

        ArrayList<Library> libraries = new ArrayList<>();

        ObjectMapper objeto = new ObjectMapper();

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("src/main/java/Ejercicios1/Ej3/archivo.json"))) {

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                libraries.add(objeto.readValue(linea,Library.class));

                Library lib = objeto.readValue(linea,Library.class);
                for (Book e: lib.getLibreria()) {

                    System.out.println(e.getTitle());

                }

            }

//            for (Library f : libraries) {
//
//                for (Book e: f.getLibreria()) {
//
//                    System.out.print(e.getTitle() + " ");
//
//                }
//
//                System.out.println();
//
//            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
