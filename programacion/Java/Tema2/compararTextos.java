package programacion.Java.Tema2;

import java.util.Scanner;


public class compararTextos {
    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);

        System.out.println("Dime algo:");
        String algo1 = leer.next();
        System.out.println("Dime otro algo:");
        String algo2 = leer.next();

        System.out.println("¿Las cadenas son iguales? = " + (algo1.equalsIgnoreCase(algo2)));
        System.out.println("¿Las cadenas son exactamente iguales? = " + (algo1.equals(algo2)));
        

    }

}
