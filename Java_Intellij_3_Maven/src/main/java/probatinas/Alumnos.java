package probatinas;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "Alumnos")
public class Alumnos {

    private ArrayList<Alumno> alumno;

    public Alumnos() {

        alumno = new ArrayList<>();

    }

    public Alumnos(ArrayList<Alumno> alumno) {
        this.alumno = alumno;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumno;
    }

    public void setAlumnos(ArrayList<Alumno> alumno) {
        this.alumno = alumno;
    }


}
