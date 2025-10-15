
import java.util.Scanner;

public class Lectura {

    public static void main(String[] args) {
        

        Scanner sc= new Scanner(System.in);
        System.out.print("Introduce un numero entero:");
        int numeroentero = sc.nextInt();
        double numerodouble = (double) numeroentero;
        System.out.println("El numero como double es:" + numerodouble);
       

    
        System.out.println("Dime el numero");
        int numero = sc.nextInt();
        System.out.println("El numero multiplicado por dos es:" +  numero * 2);
        
        
        sc.close();
        
        
    }
    
    
}