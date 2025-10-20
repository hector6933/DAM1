import java.util.Scanner;
public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        boolean correcto = true;
        int num1 = 0;
        int num2 = 0;
        String opcion;
        do {

              
              System.out.println("Elige entre estas opciones: ");
              System.out.println("Suma (+)");
              System.out.println("Resta (-)");
              System.out.println("Multiplicación (x)");
              System.out.println("División(/)");
              System.out.println("Raíz cuadrada (2)");
              System.out.println("Potencia (^)");
              System.out.println("Salir (S)");
              opcion = leer.next();

              System.out.println("OPCION: " + opcion);






            switch (opcion) {

                case "+":
                    System.out.println(num1 + " + " + num2 +" = " + (num1 + num2));
                    break;

                case "-":
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;

                case "X":
                    System.out.println(num1 + " x " + num2 + " = " + (num1 * num2));
                    break;

                case "/":
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                    break;
                case "2":
                    System.out.println("La raíz cuadrada de " + num1 + " es " + Math.sqrt(num1));
                    break;

                case "^":
                    System.out.println(num1 + " ^ " + num2 + " = " + Math.pow(num1,num2));
                    break;
                case "S":
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida !");
                    break;
            }

            if (salir) {

                System.out.println("Saliendo...");

            }
            System.out.println("Final");

        } while (!salir);

    }

}
