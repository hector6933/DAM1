package Ejercicios1.Ej9;

import Ejercicios1.Book;
import Ejercicios1.Publisher;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class Ejercicio9 {

    public static void main(String[] args) {

        Publisher publisher1 = new Publisher("Publisher1","Mi casa");

        publisher1.getLibros().add(new Book("Titulo 1","Autor 1",1990));
        publisher1.getLibros().add(new Book("Titulo 2","Autor 2",2000));
        publisher1.getLibros().add(new Book("Titulo 3","Autor 3",2010));
        publisher1.getLibros().add(new Book("Titulo 4","Autor 4",2020));
        publisher1.getLibros().add(new Book("Titulo 5","Autor 5",2025));

        // SERIALIZAR A JSON

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(new File("src/main/java/Ejercicios1/Ej9/archivo.json"),publisher1);

        } catch (IOException e) {

            System.out.println("Error en la escritura del archivo, al serializar a JSON !!!");

        }

        // SERIALIZAR A XML

        try {

            JAXBContext context = JAXBContext.newInstance(Publisher.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            marshaller.marshal(publisher1,new File("src/main/java/Ejercicios1/Ej9/archivo.xml"));

        } catch (JAXBException e) {

            System.out.println("Error al serializar a XML");

        }

    }

}
