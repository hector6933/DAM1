package probatinas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        } catch (NumberFormatException x) {

            for (Alumno e: alumnos) {

                if (e.getCurso().equalsIgnoreCase(parametro) || e.getDni().equalsIgnoreCase(parametro) || e.getNombre().equalsIgnoreCase(parametro) || e.getId().equalsIgnoreCase(parametro)) {

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

    public Integer devolverUltimoId(){

        String ultimoId = alumnos.getLast().getId();

        Matcher matcherId = Pattern.compile("\\d+").matcher(ultimoId);

        int idActual = 0;

        try {

            if (matcherId.find()) {

                idActual = Integer.parseInt(matcherId.group());

            }

        } catch (NumberFormatException e) {

            System.out.println("Error al parsear el ID del alumno");

        }

        return idActual;

    }



}
