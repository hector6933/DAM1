package Ejercicios1.Ej2;

import Ejercicios1.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio2 {

    public static void main(String[] args) {

        ObjectMapper objeto = new ObjectMapper();

        ArrayList<Book> libros = new ArrayList<>();

        try {

            try (BufferedReader leerBufer = new BufferedReader(new FileReader("src/main/java/Ejercicios1/Ej1/archivo.json"))) {

                String linea;

                while ((linea = leerBufer.readLine()) != null) {

                    libros.add(objeto.readValue(linea,Book.class));

                }

                for (Book e: libros) {

                    System.out.println(e.getTitle() + " " + e.getAuthor());

                }

            } catch (FileNotFoundException e) {

                System.out.println("Archivo NO encontrado !!!");

            } catch (IOException e) {

                System.out.println("Error en la lectura del archivo !!!");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
