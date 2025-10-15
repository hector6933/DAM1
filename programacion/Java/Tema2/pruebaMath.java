package programacion.Java.Tema2;
import java.util.Scanner;
public class pruebaMath {
    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);

        System.out.print("Dime un numero: ");
        int asd = leer.nextInt();

        System.out.print("Dime otro numero: ");
        int dsa = leer.nextInt();
        System.out.println(asd + " elevado a " + dsa + " es: " + Math.pow(asd, dsa)); // Para elevar un número
        System.out.println("El número más grande de " + asd + " y " + dsa + " es: " + Math.max(asd, dsa)); // Para sacar el número más grande

    }

}
