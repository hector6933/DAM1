import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Ejercicio1 {

    public static void mostrarNota(ArrayList<Double> notas){

        Double todas = 0.0;
        int s = 0;
        int n = 0;
        int a = 0;
        int sus = 0;
        int noValidas = 0;
        for (Double e : notas) {

            if (e > 10 || e < 0) {

                noValidas++;
                continue;

            } else if (e >= 9) {

                s++;

            } else if (e >= 7) {

                n++;

            } else if (e >=5) {

                a++;

            } else if (e >= 0) {

                sus++;

            }

            todas += e;

        }

        System.out.println("Sobresalientes: " + s);
        System.out.println("Notables: " + n);
        System.out.println("Aprobados: " + a);
        System.out.println("Suspensos: " + sus);
        System.out.println("Nota media: " + String.format("%.2f",todas/notas.size()));;

        System.out.println("Notas NO válidas: " + noValidas);

    }

    public static void main(String[] args) {

        ArrayList<Double> notaAlumnos = new ArrayList<>();

        notaAlumnos.add(8.3);
        notaAlumnos.add(3.2);
        notaAlumnos.add(4.9);
        notaAlumnos.add(2.2);
        notaAlumnos.add(10.0);
        notaAlumnos.add(10.0);
        notaAlumnos.add(10.0);
        notaAlumnos.add(10.0);
        notaAlumnos.add(10.0);
        notaAlumnos.add(6.7);
        notaAlumnos.add(5.5);
        notaAlumnos.add(4.0);
        notaAlumnos.add(4.0);

        notaAlumnos.add(11.0);
        notaAlumnos.add(-20.0);
        notaAlumnos.add(-20.0);
        notaAlumnos.add(-20.0);
        notaAlumnos.add(-20.0);

        notaAlumnos.add(10.0);
        notaAlumnos.add(10.0);
        notaAlumnos.add(6.7);
        notaAlumnos.add(10.0);
        notaAlumnos.add(6.7);;
        notaAlumnos.add(5123.5);
        notaAlumnos.add(4.4);
        notaAlumnos.add(10.0);
        notaAlumnos.add(9999999.9);

        mostrarNota(notaAlumnos);

    }

}
