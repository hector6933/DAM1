package Ejercicios1.Ej7;

import Ejercicios1.Author;
import Ejercicios1.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class Ejercicio7 {

    public static void main(String[] args) {

        Author pascual = new Author("Pascual");

        pascual.getBooksWritten().add(new Book("Libro1","Pascual",2000));
        pascual.getBooksWritten().add(new Book("Libro2","Pascual",2000));
        pascual.getBooksWritten().add(new Book("Libro3","Pascual",2000));
        pascual.getBooksWritten().add(new Book("Libro4","Pascual",2000));

        // SERIALIZAR A JSON
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("src/main/java/Ejercicios1/Ej7/archivo.json");

        try {

            mapper.writeValue(file,pascual);

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        }
        catch (IOException e) {

            System.out.println("Error en la escritura del archivo !!!");

        }

        // SERIALIZAR A XML

        File file2 = new File("src/main/java/Ejercicios1/Ej7/archivo.xml");
        if (!file2.exists()) {

            System.out.println("Archivo NO encontrado !!!");
            return;

        }
        try {

            JAXBContext context = JAXBContext.newInstance(Author.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            marshaller.marshal(pascual, file2);


        } catch (JAXBException e) {

            System.out.println("Error al serializar a XML !!!");

        }


    }

}
