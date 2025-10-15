package programacion.Java.Tema1.CosasBasicas;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


            Scanner hola = new Scanner(System.in);
            int num2 = hola.nextInt();
            System.out.println("Tu numero de mierda es: " + num2);
            System.out.println(num2 * num2);

           /* System.out.println("Dime tu nombre:");
            boolean remon;

            if (nombre.equalsIgnoreCase("卐")) {

                System.out.println("REMOOOOOOOOOOON !!!!卐卐卐");

            } else {

                System.out.println("Hola " + nombre + " que tal estas");

            }*/

        /*    do {
                remon = false;
                System.out.println("Hola, quien eres (espero que NO seas remon)");
                String nombre = hola.next();

                if (nombre.equalsIgnoreCase("Remon")) {

                    System.out.println("NOOOOO REMON NOOOO");
                    remon = true;

                } else {

                    System.out.println("Hola " + nombre + " que tal estas");

                }

            } while (remon);*/
        boolean si;

        do {
            si = true;
            System.out.println("Dime tu puta edad ahora mismo");

            Scanner edadd = new Scanner(System.in);
            int edad =edadd.nextInt();

            if (edad >= 18){
                System.out.println("Muy bien eres mayor de edad te dejo pasar ");
                si = false;
            } else {
                System.out.println("Bro mienteme que si no no te dejo entrar al porno");
            }
        }while (si);

}
}