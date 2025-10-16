import java.util.*;

public class pruebas {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Dime el primer numero");
            double num1 = sc.nextDouble();
            System.out.println("Dime el segundo numero");
            double num2 = sc.nextDouble();


            System.out.println("Dime que operacion deseeas (+) (-) (*) (/)");
            String r = sc.next();

            if (r.equalsIgnoreCase("+")) {

                System.out.println("El resultado de la suma es: " + (num1 + num2));
            }

            if (r.equalsIgnoreCase("-")) {

                System.out.println("El resultado de la resta es: " + (num1 - num2));
            }

            if (r.equalsIgnoreCase("*")) {

                System.out.println("El resultado de la multipliacion es: " + (num1 * num2));
            }

            if (r.equalsIgnoreCase("/")) {
                if (num2 == 0) {
                    System.out.println("No se puede dividir entre 0");
                } else {
                    System.out.println("El resultado de la division es: " + (num1 / num2));
                }

            }

        }


}
