package probatinas;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class Demo1Serializar {

    public static void main(String[] args) {

        Alumnos alumnosDAM = new Alumnos();

        Alumno alumno1 = new Alumno("Nombre 1","Apellido 1",33,"19491836R", Date.valueOf("2025-01-01"),"DAM1");
        Alumno alumno2 = new Alumno("Nombre 2","Apellido 2",69,"49030103T", Date.valueOf("2009-12-03"),"DAM1");
        Alumno alumno3 = new Alumno("Nombre 3","Apellido 3",22,"12312352F", Date.valueOf("2020-12-03"),"DAM1");
        Alumno alumno4 = new Alumno("Nombre 4","Apellido 4",5,"93898328R", Date.valueOf("1990-12-03"),"DAM1");
        Alumno alumno5 = new Alumno("Nombre 5","Apellido 5",100,"I293I3G", Date.valueOf("2026-12-03"),"DAM1");

        alumnosDAM.getAlumnos().add(alumno1);
        alumnosDAM.getAlumnos().add(alumno2);
        alumnosDAM.getAlumnos().add(alumno3);
        alumnosDAM.getAlumnos().add(alumno4);
        alumnosDAM.getAlumnos().add(alumno5);

        // SERIALIZAR ALUMNOS A JSON

        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/probatinas/alumnos.json"), alumnosDAM);

        } catch (IOException e) {

            System.out.println("Error al serializar a JSON !!!");

        }

        // SERIALIZAR ALUMNOS A XML

        try {

            JAXBContext context = JAXBContext.newInstance(Alumnos.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            marshaller.marshal(alumnosDAM,new File("src/main/java/probatinas/alumnos.xml"));

        } catch (JAXBException e) {

            System.out.println("Error al serializar a XML !!!");
            e.printStackTrace();

        }

    }

}
