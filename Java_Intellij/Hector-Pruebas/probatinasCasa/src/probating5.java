import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class probating5 {

    public static void main(String[] args) {

        Integer[] numeros = {477,2,2,7,590,700,9,6,6,3,6,7,4};

        ArrayList<Integer> numerines = new ArrayList<Integer>(Arrays.asList(numeros));

        numerines.add(55);
        numerines.add(55);
        numerines.add(55);
        numerines.add(55);
        numerines.add(55);
        numerines.add(55);


        Integer[] numeracos = (Integer[]) numerines.toArray(new Integer[numerines.size()]);


        for (Integer numerosss : numeracos) {

            System.out.print(numerosss + " ");

        }

        System.out.println();
        int asd = 33;

        String dsa = String.valueOf(asd);

        System.out.println(dsa + 1);

        LocalDate date = LocalDate.now();

        System.out.println(date);

        LocalDate date2 = LocalDate.of(1989, Month.NOVEMBER,8);

        System.out.println(date2);

        LocalDate date3 = LocalDate.parse("2022-12-10");

        System.out.println(date3);


        LocalTime time = LocalTime.now();

        System.out.println(time);

        LocalTime time2 = LocalTime.of(12,30,30);

        System.out.println(time2);

        LocalTime time3 = LocalTime.parse("15:45:50");

        System.out.println(time3);

        Arrays.sort(numeros);

        System.out.println(Arrays.binarySearch(numeros, 3));

        Collections.sort(numerines);

        System.out.println(numerines);

        System.out.println(Arrays.binarySearch(numerines.toArray(), 7));

        // La programacion estructurada estudia la forma de organizar la programacion para generar un programa legible y facil de mantener, obteniendo asi un software de calidad
        // La programacion modular es una evolucion de la programacion estrcuturada
        // Un objeto es un conjunto de software con comportamiento y estado
        // Una clase es un modelo a partir del cual se crean objetos

        System.out.println("Cosas:");
        System.out.println("A".compareTo("B")<0);
        System.out.println("X".compareTo("X")==0);
        System.out.println("A".compareTo("B"));

        String pascual = "Hola que tal";

        System.out.println(pascual.substring(5));



    }

}
