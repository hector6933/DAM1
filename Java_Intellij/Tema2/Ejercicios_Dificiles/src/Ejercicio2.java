import java.util.Scanner;
public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean salir = false;
        boolean correcto;
        int num1 = 0;
        int num2 = 0;
        String opcion;
        do {

            correcto = false;

            System.out.println("-------------------------------------------------------------------");
            System.out.println("Elige entre estas opciones: ");
            System.out.println("Suma (+)");
            System.out.println("Resta (-)");
            System.out.println("Multiplicación (x)");
            System.out.println("División (/)");
            System.out.println("Raíz cuadrada (2)");
            System.out.println("Potencia (^)");
            System.out.println("Salir (S)");
            opcion = leer.next();
            leer.nextLine();

            System.out.println("OPCION: " + opcion);

            if (opcion.equals("+") || opcion.equals("-") || opcion.equalsIgnoreCase("x") || opcion.equals("/") || opcion.equals("^")) {

                do {

                    System.out.print("Dime el numero 1: ");

                    if (!leer.hasNextInt()) {

                        System.out.println("Dato inválido, introduce un número entero porfavor");
                        leer.nextLine();

                    } else {

                        num1 = leer.nextInt();
                        leer.nextLine();

                        do {
                            System.out.print("Dime el número 2: ");
                            if (!leer.hasNextInt()) {

                                System.out.println("Inválido, introduce un número entero porfavor");
                                leer.nextLine();

                            } else {

                                num2 = leer.nextInt();
                                leer.nextLine();
                                correcto = true;

                            }

                        } while (!correcto);

                    }

                } while (!correcto);

            } else if (opcion.equals("2")) {

                do {

                    System.out.println("Dime el número");
                    if (!leer.hasNextInt()) {

                        System.out.println("Inválido, introduce un número entero porfavor");
                        leer.nextLine();

                    } else {

                        num1 = leer.nextInt();
                        leer.nextLine();
                        correcto = true;

                    }

                } while (!correcto);

            }
            System.out.println("-------------------------------------------------------------------");
            switch (opcion) {

                case "+":
                    System.out.println(num1 + " + " + num2 +" = " + (num1 + num2));
                    break;

                case "-":
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;

                case "X","x":
                    System.out.println(num1 + " x " + num2 + " = " + (num1 * num2));
                    break;

                case "/":
                    if (num2 == 0) {

                        System.out.println("NO se puede dividir entre 0");

                    } else {

                        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));

                    }

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


        } while (!salir);

    }

}
