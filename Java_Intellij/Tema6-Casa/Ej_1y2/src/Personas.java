import java.util.ArrayList;

public class Personas {

    ArrayList<Persona> lasPersonas = new ArrayList<>();

    public Personas() {


    }

    public Personas(ArrayList<Persona> lasPersonas) {
        this.lasPersonas = lasPersonas;
    }

    public void addPersonas(Persona persona) {

        lasPersonas.add(persona);

    }

    public void setLasPersonas(ArrayList<Persona> lasPersonas) {
        this.lasPersonas = lasPersonas;
    }

    public String mostrarPersonas() {

        return lasPersonas.toString();

    }

    public double getEdadMedia() {

        double total = 0.0;
        for (Persona persona : lasPersonas) {

            total = total + persona.calcularEdad();

        }
        return total/lasPersonas.size();
    }

    public String getPersonaMayorEdad() {

        int max = lasPersonas.getFirst().calcularEdad();
        int index = -1;
        int indexMaxEdad = 0;

        for (Persona persona : lasPersonas) {

            index++;
            if (persona.calcularEdad() > max) {

                max = persona.calcularEdad();
                indexMaxEdad = index;

            }

        }

        return lasPersonas.get(indexMaxEdad).getNombre();

    }
}
