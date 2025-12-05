import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio19 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int total = 0;

        String introducir;
        System.out.println("Introduce números separados por comas: ");
        introducir = leer.nextLine();

        ArrayList<String> numerosIntroducidos = new ArrayList<>(Arrays.asList(introducir.split(",")));

        try {

            for (int i = 0; i < numerosIntroducidos.size(); i++) {

                total+= Integer.parseInt(numerosIntroducidos.get(i).trim());

            }

            System.out.println("La suma es de " + total);

        } catch (Exception e) {

            System.out.println("Formato inválido de números !!!");

        }

        leer.close();

    }

}
