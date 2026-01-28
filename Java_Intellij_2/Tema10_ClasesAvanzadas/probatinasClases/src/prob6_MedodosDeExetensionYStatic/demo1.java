package prob6_MedodosDeExetensionYStatic;

import java.util.Scanner;

public class demo1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce un texto: ");
        System.out.print("> ");
        String texto = leer.nextLine();

        System.out.println("Tu texto al revés: ");
        System.out.println(miClase.reverse(texto));

        leer.close();

    }

}
