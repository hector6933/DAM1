package prob1_Personas;

import java.util.ArrayList;

public class Personas {

    private ArrayList<Persona> grupoPersonas;

    public Personas() {

        grupoPersonas = new ArrayList<>();

    }

    public Double getEdadMedia(){

        if (grupoPersonas.isEmpty()) {

            return null;

        }

        Double total = 0.0;

        for (Persona e : grupoPersonas) {

            total += e.getEdad();

        }

        return total/grupoPersonas.size();

    }

    public void buscarPersonaEdad(int edad) {

        for (Persona e : grupoPersonas) {

            if (e.getEdad() == edad) {

                System.out.println(e.toString());

            }

        }

    }

    public Persona buscarPersonaPos(int num) {

        return grupoPersonas.get(num);

    }

    public void addPersona(Persona e) {

        grupoPersonas.add(e);

    }

    public Personas(ArrayList<Persona> grupoPersonas) {
        this.grupoPersonas = grupoPersonas;
    }

    public ArrayList<Persona> getGrupoPersonas() {
        return grupoPersonas;
    }

    public void setGrupoPersonas(ArrayList<Persona> grupoPersonas) {
        this.grupoPersonas = grupoPersonas;
    }
}
