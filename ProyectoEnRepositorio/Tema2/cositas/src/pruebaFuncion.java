import java.util.Scanner;
// Probando funciones
// Programa protegido contra:
//      - Usuario tonto
//      - Profesor cabrón
public class pruebaFuncion {

    static Scanner leer = new Scanner(System.in);


    public static double pedirDouble() {


        boolean salir = false;
        do {
            System.out.print("Introduce un número entero: ");
            if (leer.hasNextDouble()) {

                salir = true;
                return leer.nextDouble();

            } else {

                System.out.println("Eso no es un número entero válido");
                leer.nextLine();

            }
        } while (!salir);

        return 0;

    }

    public static double sumar(double numero1, double numero2) {

        return numero1 + numero2;

    }

    public static double resta(double numero1, double numero2) {

        return numero1 - numero2;

    }

    public static double multiplicar(double numero1, double numero2) {

        return numero1 * numero2;

    }

    public static double dividir(double numero1, double numero2) {

        if (numero2 == 0) {

            System.out.println("NO se puede dividir entre 0");

        } else {

            return numero1 / numero2;

        }

        return 0;

    }

    public static double raizCuadrada(double numero1) {

        return Math.sqrt(numero1);

    }

    public static double potencia(double numero1, double numero2) {

        return Math.pow(numero1,numero2);

    }

    public static double factorial(double numero) {

        if (numero == 0 || numero == 1) {

            return 1;

        } else {

            return numero * factorial(numero - 1);

        }

    }
    public static void main(String[] args) {


        int num1;
        int num2 = 0;
        String opcion;
        boolean salir;
        do {

            salir = false;


            System.out.println("Elige entre estas opciones: ");
            System.out.println("Suma (+)");
            System.out.println("Resta (-)");
            System.out.println("Multiplicación (x)");
            System.out.println("División (/)");
            System.out.println("Raíz cuadrada (2)");
            System.out.println("Potencia (^)");
            System.out.println("Factorial (F)");
            System.out.println("Salir (S)");
            opcion = leer.next();
            leer.nextLine();


            switch (opcion) {

                case "+":
                    System.out.println("La suma es: " + sumar(pedirDouble(),pedirDouble()));
                    break;
                case "F","f":
                    System.out.println("El factorial es de " + factorial(pedirDouble()));
                    break;

                default:
                    System.out.println("Que dices");
                    break;


            }

            System.out.println("-------------------------------------------------------------------");

        } while (!salir);

    }



}
