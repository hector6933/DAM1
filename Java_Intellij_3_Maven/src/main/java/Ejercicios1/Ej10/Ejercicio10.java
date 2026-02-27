package Ejercicios1.Ej10;

import Ejercicios1.Author;
import Ejercicios1.Book;
import Ejercicios1.LibraryCatalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Ejercicio10 {

    public static void main(String[] args) {

        LibraryCatalog catalogo1 = new LibraryCatalog();

        //catalogo1.getMapa().put(new Book("Titulo","Autor",2000),new Author("Yo"));

        catalogo1.getMapa().put(new Book("Titulo 1","Autor 1",2000),new Author("Autor 1"));
        catalogo1.getMapa().put(new Book("Titulo 2","Autor 1",1900),new Author("Autor 1"));
        catalogo1.getMapa().put(new Book("Titulo 3","Autor 1",2020),new Author("Autor 1"));
        catalogo1.getMapa().put(new Book("Titulo 4","Autor 1",2015),new Author("Autor 1"));

        catalogo1.getMapa().put(new Book("Titulo 5","Autor 2",2026),new Author("Autor 2"));
        catalogo1.getMapa().put(new Book("Titulo 6","Autor 2",2001),new Author("Autor 2"));
        catalogo1.getMapa().put(new Book("Titulo 7","Autor 2",1959),new Author("Autor 2"));
        catalogo1.getMapa().put(new Book("Titulo 8","Autor 2",1971),new Author("Autor 2"));

        // SERIALIZAR A JSON

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(new File("src/main/java/Ejercicios1/Ej10/archivo.json"),catalogo1);

        } catch (IOException e) {

            System.out.println("Error en la escritura al serializar a JSON !!!");

        }

        // SERIALIZAR A XML

        try {

            JAXBContext context = JAXBContext.newInstance(LibraryCatalog.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            marshaller.marshal(catalogo1, new File("src/main/java/Ejercicios1/Ej10/archivo.xml"));

        } catch (JAXBException e) {

            System.out.println("Error al serializar a XML !!!");

        }


    }

}
