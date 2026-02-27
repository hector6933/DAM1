package Ejercicios1.Ej6;

import Ejercicios1.Book;
import Ejercicios1.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;

public class Ejercicio6 {

    public static void main(String[] args) {

        try {

            Library libreria = new Library();

            libreria.getLibreria().add(new Book("Titulo 1", "Autor 1", 2000));
            libreria.getLibreria().add(new Book("Titulo 2", "Autor 2", 1990));
            libreria.getLibreria().add(new Book("Titulo 3", "Autor 3", 2020));
            libreria.getLibreria().add(new Book("Titulo 4", "Autor 4", 2030));


            JAXBContext context = JAXBContext.newInstance(Library.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File("src/main/java/Ejercicios1/Ej6/archivo.xml");

            marshaller.marshal(libreria,file);



        } catch (JAXBException e) {

            System.out.println("Error al serializar !!!");
            e.printStackTrace();

        }


    }

}
