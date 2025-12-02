import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio11_Eficiente {

    public static void main(String args[]) {

        // De esta forma es mucho más eficiente, ya que solamente le indicamos en estas dos variables el rango de numeros random
        // Sin embargo, en el ej11 NO eificnete si queremos cambiar el rango, tenemos que cambiar también el tamaño del Array
        int min = -10;
        int max = 10;
        int capacidad = max - min;
        int contador = 0;
        int numeroMeter;
        ArrayList<Integer> randoms = new ArrayList<>(); // Se puede hacer perfectamente sin ArrayList --> int[] randoms = new int[capacidad];

        while (contador < capacidad) {

            numeroMeter = (int) (Math.random() * (max - min + 1)) + min;

            if (!randoms.contains(numeroMeter)) {

                randoms.add(numeroMeter);
                contador++;

            }

        }

        System.out.println(randoms);

    }

}
