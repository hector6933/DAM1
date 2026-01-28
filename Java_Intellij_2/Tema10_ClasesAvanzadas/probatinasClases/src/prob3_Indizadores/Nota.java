package prob3_Indizadores;

public class Nota {

    public Double[] calificaciones;

    public Nota(int size){

        if (size <= 0) {

            throw new IllegalArgumentException("El tamaño debe de ser mayor que 0");

        } else {

            calificaciones = new Double[size];

        }

    }

    public void setNota(int indice, Double nota){

        if (indice < 0 || indice > calificaciones.length) {

            throw new IllegalArgumentException("Indice NO válido !!!");

        } else {

            calificaciones[indice] = nota;

        }

    }

    public Double getNota(int indice) {

        if (indice < 0 || indice > calificaciones.length) {

            throw new IllegalArgumentException("Indice NO válido !!!");

        } else {

            return calificaciones[indice];

        }

    }

    public Double[] getCalificaciones() {
        return calificaciones;
    }
}
