package Ejercicios1.Ej8;

import Ejercicios1.Author;
import Ejercicios1.Book;
import Ejercicios1.BookStore;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio8 {

    public static void main(String[] args) {

        // SERIALIZAR A JSON

        BookStore chomonStore = new BookStore();

        Author pascual = new Author("Pascual");
        pascual.getBooksWritten().add(new Book("Titulo 1", "Pascual", 2000));
        pascual.getBooksWritten().add(new Book("Titulo 2", "Pascual", 1990));
        pascual.getBooksWritten().add(new Book("Titulo 3", "Pascual", 2020));

        Author juanma = new Author("Juanma");
        juanma.getBooksWritten().add(new Book("Titulo 1", "Juanma", 2000));
        juanma.getBooksWritten().add(new Book("Titulo 2", "Juanma", 1990));
        juanma.getBooksWritten().add(new Book("Titulo 3", "Juanma", 2020));

        chomonStore.getLibros().add(pascual.getBooksWritten().get(0));
        chomonStore.getLibros().add(pascual.getBooksWritten().get(1));
        chomonStore.getLibros().add(pascual.getBooksWritten().get(2));
        chomonStore.getLibros().add(juanma.getBooksWritten().get(0));
        chomonStore.getLibros().add(juanma.getBooksWritten().get(1));
        chomonStore.getLibros().add(juanma.getBooksWritten().get(2));

        chomonStore.getAutores().add(pascual);
        chomonStore.getAutores().add(juanma);

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(new File("src/main/java/Ejercicios1/Ej8/archivo.json"),chomonStore);

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la escritura del archivo !!!");

        }

        // SERIALIZACIÓN A XML

        try {

            JAXBContext context = JAXBContext.newInstance(BookStore.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            marshaller.marshal(chomonStore,new File("src/main/java/Ejercicios1/Ej8/archivo.xml"));

        } catch (JAXBException e) {

            System.out.println("Error al serializar a XML !!!");

        }

    }

}
