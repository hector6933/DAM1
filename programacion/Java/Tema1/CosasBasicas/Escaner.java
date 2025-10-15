package programacion.Java.Tema1.CosasBasicas;
import java.util.Scanner;

public class Escaner {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int numero = leer.nextInt();

        double numeroDouble = numero;

        System.out.println("El número como double es: " + numeroDouble);

        leer.close();
    }


}
