package probatinas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Alumnos {

    private ArrayList<Alumno> alumnos;

    public Alumnos() {

        alumnos = new ArrayList<>();

    }

    public Alumnos(ArrayList<Alumno> alumno) {
        this.alumnos = alumno;
    }

    @XmlElement(name = "alumno")
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumno) {
        this.alumnos = alumno;
    }

    public ArrayList<Alumno> buscarAlumnos(String parametro){

        if (alumnos.isEmpty()) return null;

        ArrayList<Alumno> busqueda = new ArrayList<>();

        try {

            int parametroInt = Integer.parseInt(parametro);

            for (Alumno e: alumnos) {

                if (e.getEdad() == parametroInt) {

                    busqueda.add(e);

                }

            }

        } catch (NumberFormatException e) {

            for (Alumno e: alumnos) {

                if (e.getCurso().equalsIgnoreCase(parametro) || e.getDni().equalsIgnoreCase(parametro) || e.getNombre().equalsIgnoreCase(parametro)) {

                    busqueda.add(e);

                }

            }

        }

        return busqueda;
    }

    public void mostrarAlumnos(){

        for (Alumno e: getAlumnos()) {

            System.out.println(e);

        }

    }


}
