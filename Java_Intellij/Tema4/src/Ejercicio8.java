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

        int opcion = 0;
        boolean correcto = false;
        do {

            System.out.println("Elige:");
            System.out.println("1 - Introducir enteros");
            System.out.println("2 - Introducir reales");
            System.out.println("3 - Salir ");
            System.out.print("> ");
            if (leer.hasNextInt()) {

                opcion = leer.nextInt();
                correcto = true;

            } else {

                System.out.println("Introduce un número entero como opción !!!");

            }
            leer.nextLine();

        } while (!correcto);
        correcto = false;

            switch (opcion) {

                case 1:
                    do {
                        System.out.println("Introduce el primer numero entero:");
                        System.out.print("> ");
                        try {

                            int num1 = Integer.parseInt(leer.nextLine());
                            do {
                                System.out.println("Introduce el segundo numero entero:");
                                System.out.print("> ");
                                try {

                                    int num2 = Integer.parseInt(leer.nextLine());

                                    System.out.println("El mayor de " + num1 + " y " + num2 + " es: " + mayor(num1,num2));
                                    correcto = true;

                                } catch (NumberFormatException e) {

                                    System.out.println("Número entero inválido !!!");

                                }

                            } while (!correcto);

                        } catch (NumberFormatException e) {

                            System.out.println("Número entero inválido !!!");

                        }

                    } while (!correcto);
                    break;
                case 2:
                    do {
                        System.out.println("Introduce el primer numero real:");
                        System.out.print("> ");
                        try {

                            double num1 = Double.parseDouble(leer.nextLine());
                            do {
                                System.out.println("Introduce el segundo numero real:");
                                System.out.print("> ");
                                try {

                                    double num2 = Double.parseDouble(leer.nextLine());

                                    System.out.println("El mayor de " + num1 + " y " + num2 + " es: " + mayor(num1, num2));
                                    correcto = true;

                                } catch (NumberFormatException e) {

                                    System.out.println("Número real inválido !!!");

                                }

                            } while (!correcto);

                        } catch (NumberFormatException e) {

                            System.out.println("Número real inválido !!!");

                        }
                    } while (!correcto);
                    break;
                case 3:
                    System.out.println("Saliando...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }

    }

}
