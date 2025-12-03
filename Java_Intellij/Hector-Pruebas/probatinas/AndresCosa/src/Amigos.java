import java.util.ArrayList;

public class Amigos {

    ArrayList<Persona> amigos = new ArrayList<>();

    double calcularEdadMedia() {

        double total = 0;

        for (Persona nose : amigos) {

            total = total + nose.getEdad();

        }

        return total/amigos.size();

    }





}
