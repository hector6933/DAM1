package Probatinas.AlmacenarPersonas.Demo;

import Probatinas.AlmacenarPersonas.Clases.Persona;

import java.util.Scanner;

public class Demo1 {

    public static void verUsuarios() {
        

    }


    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean salir = false;

        do {

            System.out.println("Elige una opción: ");
            System.out.println(" 1 - Ver usuarios");
            System.out.println(" 2 - Modificar usuarios");
            System.out.println(" 0 - Salir");
            System.out.print("> ");

            try {

                int opt = Integer.parseInt(leer.nextLine());

                switch (opt) {

                   case 1:

                        break;
                    case 2:

                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida !");
                        break;
                }

            } catch (ArithmeticException e) {

                System.out.println("Introduce un número !!!!");

            }

        } while (!salir);


        leer.close();
    }

}
