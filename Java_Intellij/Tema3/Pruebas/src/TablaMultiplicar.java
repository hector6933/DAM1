import java.util.Scanner;
public class TablaMultiplicar {
    public static void main(String[] args) {
//Inicializar objeto Scanner para leer de la consola
        Scanner sc = new Scanner(System.in);
//Mostrar información al usuario
        System.out.println("Tabla de multiplicar");
        System.out.println("Introduce un número");
//Leer valor, nos aseguramos de que es un entero antes de seguir
        if(sc.hasNextInt()) {
            int numero = sc.nextInt();
            sc.nextLine();
//Contador i, irá de 1 a 10
            int i=1;
            while(i<=10) { //Condición del bucle
                System.out.println(i + " x " + numero + " = " + i*numero);
                i++; //incremento, no olvidar para evitar bucle infinito
            }
        } else {
            System.out.println("El número debe ser un entero");
        }
// cerrar scanner
        sc.close();
    }
}
