import java.util.Scanner;
public class Ejercicio5 {

    public static void triangulo(int numero, int letra) {

        char letrita = (char) letra;
        int columnas = numero;
        for (int i = 0; i < numero; i++) {

            for (int j = 0; j < columnas; j++) {

                System.out.print(letrita);

            }
            System.out.println(" ");
            columnas--;

        }

    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int letra;
        int numero = 0;

        do {

            System.out.println("Introduce una letra del abecedario: ");
            System.out.print("> ");
            letra = leer.next().charAt(0);
            leer.nextLine();
            if ((letra >= 'a' && letra <= 'z') || (letra >= 'A' && letra <= 'Z')) {

                do {
                    System.out.println("Introduce un número entero positivo: ");
                    System.out.print("> ");
                    try {

                        numero = Integer.parseInt(leer.nextLine());
                        if (numero < 0) {

                            System.out.println("Error, ese número es negativo");

                        } else {

                            correcto = true;

                        }

                    } catch (RuntimeException e) {

                        System.out.println("Número entero inválido !!!");

                    }

                } while (!correcto);

            } else {

                System.out.println("Esa letra NO está en el abecedario");

            }

        } while (!correcto);

        triangulo(numero,letra);

        leer.close();

    }

}
