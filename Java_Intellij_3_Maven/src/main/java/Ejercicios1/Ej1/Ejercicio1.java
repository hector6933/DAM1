package Ejercicios1.Ej1;

import Ejercicios1.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio1 {

    public static void main(String[] args) {

        Book libro = new Book("Las inimaginables aventuras de pablo","Yo",2000);

        ObjectMapper objeto = new ObjectMapper();

        try {

            String jotason = objeto.writeValueAsString(libro);
            try (BufferedWriter escribirBufer = new BufferedWriter(new FileWriter("src/main/java/Ejercicios1/Ej1/archivo.json",true))) {


                escribirBufer.write(jotason);
                escribirBufer.newLine();


            } catch (FileNotFoundException e) {

                System.out.println("Archivo NO encontrado !!! ");

            } catch (IOException e) {

                System.out.println("Error en la escritura del archivo !!!");

            }

        } catch (JsonProcessingException e) {

            System.out.println("Error al convertir a formato JSON");

        }

    }

}
