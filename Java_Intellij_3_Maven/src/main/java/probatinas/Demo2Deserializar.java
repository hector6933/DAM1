package probatinas;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

public class Demo2Deserializar {

    public static void main(String[] args) {

        // DESERIALIZAR DE JSON

        ObjectMapper mapper = new ObjectMapper();

        Alumnos alumnosDam = null;

        try {

            alumnosDam = mapper.readValue(new File("src/main/java/probatinas/alumnos.json"), Alumnos.class);

        } catch (IOException e) {

            System.out.println("Error al deserializar de JSON !!!: ");
            e.printStackTrace();

        }

        System.out.println("------------------------------");
        System.out.println("Alumnos DAM1: ");
        alumnosDam.mostrarAlumnos();


        // DESERIALIZAR DE XML


        Alumnos alumnosDam2 = null;

        try {

            JAXBContext context = JAXBContext.newInstance(Alumnos.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            alumnosDam2 = (Alumnos) unmarshaller.unmarshal(new File("src/main/java/probatinas/alumnos.xml"));


        } catch (JAXBException e) {

            System.out.println("Error al deserializar de XML !!!: ");
            e.printStackTrace();

        }

        System.out.println("------------------------------");
        System.out.println("Alumnos DAM2: ");
        alumnosDam2.mostrarAlumnos();




    }

}
