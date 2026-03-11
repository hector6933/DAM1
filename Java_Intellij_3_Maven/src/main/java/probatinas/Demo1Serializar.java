package probatinas;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Demo1Serializar {

    public static void main(String[] args) {

        Alumnos alumnosDAM = new Alumnos();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Alumno alumno1 = null;
        Alumno alumno2 = null;
        Alumno alumno3 = null;
        Alumno alumno4 = null;
        Alumno alumno5 = null;

        try {

            alumno1 = new Alumno("Nombre 1","Apellido 1",33,"19491836R", sdf.parse("01/01/2025"),"DAM1");
            alumno2 = new Alumno("Nombre 2","Apellido 2",69,"49030103T",sdf.parse("03/12/2012"),"DAM1");
            alumno3 = new Alumno("Nombre 3","Apellido 3",22,"12312352F",sdf.parse("03/12/2020"),"DAM1");
            alumno4 = new Alumno("Nombre 4","Apellido 4",5,"93898328R",sdf.parse("03/12/1990"),"DAM1");
            alumno5 = new Alumno("Nombre 5","Apellido 5",100,"I293I3G",sdf.parse("03/12/2026"),"DAM1");

        } catch (Exception e) {

            e.printStackTrace();

        }


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
