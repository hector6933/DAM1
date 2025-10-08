package ejercicios1;

import java.util.*;

public class Ejercicio1 {

    public static void main(String[] args) {

        float PI = 3.14F;
        int radio;
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Dime el radio de la circunferencia en cm:");
        radio = leer.nextInt();
        
        System.out.println("La longitud de la circunferencia es de: " + PI*radio*2 + " cm");
        
    }


}

    