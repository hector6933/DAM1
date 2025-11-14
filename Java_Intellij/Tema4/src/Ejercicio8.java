import java.util.Scanner;
public class Ejercicio8 {

    public static int mayor(int num1, int num2) {

        return Math.max(num1,num2);
    }

    public static double mayor(double num1, double num2) {

        return Math.max(num1,num2);
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        String opcion;
        boolean correcto = false;
        do {
            System.out.println("Elige:");
            System.out.println("1 - Introducir enteros");
            System.out.println("2 - Introducir reales");
            System.out.print("> ");
            opcion = leer.next();
            leer.nextLine();
            switch (opcion) {

                case 1:
                    do {
                        try {

                            System.out.println("Introduce los números enteros");
                            

                        }

                    } while (!correcto);
                    break;
                case 2:
                    break;
                default:
                    break;
            }


        } while (!correcto);

    }

}
