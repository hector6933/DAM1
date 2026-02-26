package Ejercicios1.Ej5;

import Ejercicios1.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class Ejercicio5 {

    public static void main(String[] args) {

        Book libro = new Book("Titulo 1", "Autor1",2000);

        try {

            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            File file = new File("src/main/java/Ejercicios1/Ej5/archivo.xml");

            try (BufferedWriter escribirBufer = new BufferedWriter(new FileWriter("src/main/java/Ejercicios1/Ej5/archivo.xml"))) {

                marshaller.marshal(libro,file);


            } catch (FileNotFoundException e) {

                System.out.println("Archivo NO encontrado !!!");

            } catch (IOException e) {

                System.out.println("Error en la escritura del archivo !!!");

            }


        } catch (JAXBException e) {

            e.printStackTrace();

        }

    }

}
