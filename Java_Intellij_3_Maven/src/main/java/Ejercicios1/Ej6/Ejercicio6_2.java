package Ejercicios1.Ej6;

import Ejercicios1.Book;
import Ejercicios1.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Ejercicio6_2 {

    public static void main(String[] args) {

        Library libreria = new Library();

        try {

            JAXBContext context = JAXBContext.newInstance(Library.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            File file = new File("src/main/java/Ejercicios1/Ej6/archivo.xml");

            libreria = (Library) unmarshaller.unmarshal(file);

            for (Book e: libreria.getLibreria()) {

                System.out.println(e.toString());

            }

        } catch (JAXBException e) {

            System.out.println("Error al deserializar !!!");

        }

    }

}
