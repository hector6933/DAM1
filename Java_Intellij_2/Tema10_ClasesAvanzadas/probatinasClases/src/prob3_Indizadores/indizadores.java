package prob3_Indizadores;

public class indizadores {

    public static void main(String[] args) {

        Nota notasProgramacion = new Nota(5);

        notasProgramacion.setNota(0,5.5);
        notasProgramacion.setNota(1,4.5);
        notasProgramacion.setNota(2,10.0);

        notasProgramacion.setNota(4,6.7);

        System.out.println("Notas:");
        for (Double e: notasProgramacion.getCalificaciones()) {

            System.out.println(e);

        }

    }
}
