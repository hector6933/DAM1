package Ejercicios1.Ej4;

import Ejercicios1.Book;
import Ejercicios1.Library;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class Ejercicio4 {

    public static void main(String[] args) {

        ArrayList<Library> libraries;

        ObjectMapper objeto = new ObjectMapper();

        try {

            libraries = objeto.readValue(new File("src/main/java/Ejercicios1/Ej3/archivo.json"), new TypeReference<ArrayList<Library>>(){});

            for (Library e: libraries) {

                System.out.println(e.getLibreria());

            }

        } catch (IOException e) {

            System.out.println("Error al deserializar a JSON !!!");

        }

//        try (BufferedReader leerBufer = new BufferedReader(new FileReader("src/main/java/Ejercicios1/Ej3/archivo.json"))) {
//
//            String linea;
//            int i = 1;
//            while ((linea = leerBufer.readLine()) != null) {
//
//                libraries.add(objeto.readValue(linea,Library.class));
//
//                Library lib = objeto.readValue(linea,Library.class);
//                System.out.println("Librería " + i + ":");
//                i++;
//
//                for (Book e: lib.getLibreria()) {
//
//                    System.out.print(e.getTitle() + " ");
//
//                }
//                System.out.println();
//
//            }
//
////            for (Library f : libraries) {
////
////                for (Book e: f.getLibreria()) {
////
////                    System.out.print(e.getTitle() + " ");
////
////                }
////
////                System.out.println();
////
////            }
//
//        } catch (FileNotFoundException e) {
//
//            System.out.println("Archivo NO encontrado !!!");
//
//        } catch (IOException e) {
//
//            System.out.println("Error en la lectura del archivo !!!");
//
//        }

    }

}
