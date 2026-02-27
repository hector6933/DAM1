package Ejercicios1.Ej5;

import Ejercicios1.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

public class Ejercicio5_2 {

    public static void main(String[] args) {

        try {

            JAXBContext context = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            File file = new File("src/main/java/Ejercicios1/Ej5/archivo.xml");

            Book libro = (Book) unmarshaller.unmarshal(file);

            System.out.println(libro.getTitle());
            System.out.println(libro.getAuthor());

        } catch (JAXBException e) {

            System.out.println("Error al deserializar !!!");

        }


    }

}
