import java.util.*;


public class andres {
    public static void main(String[] args) {

        Scanner nigga = new Scanner(System.in);

        boolean s = false;
        double num1 = 0;
        double num2 = 0;

        while (s == false) {
            System.out.println("Dime que operacion desea hacer: (+) (-) (*) (s)");
            String r = nigga.next();
            nigga.nextLine();

            if (r.equalsIgnoreCase("+") || r.equalsIgnoreCase("-") || r.equalsIgnoreCase("*"))  {

                System.out.println("Dime el primer numero");

                while (!nigga.hasNextDouble()) {
                    System.out.println("Dime un numero valido");
                    nigga.nextLine();
                }

                num1 = nigga.nextDouble();
                nigga.nextLine();


                System.out.println("Dime el segundo numero");

                while (!nigga.hasNextDouble()) {
                    System.out.println("Dime un numero valido");
                    nigga.nextLine();
                }

                num2 = nigga.nextDouble();
            }


            switch (r) {
                case "+":
                    System.out.println("La operacion de suma es " + (num1 + num2));
                    break;

                case "-":
                    System.out.println("La operacion de resta es " + (num1 - num2));
                    break;

                case "*":
                    System.out.println("La operacion de multiplicación es " + (num1 * num2));
                    break;

                case "s", "S":
                    System.out.println("Hasta luegoooooooo!");
                    s = true;
                    break;

                default:
                    System.out.println("Tus muertos, dime una opcion valida");
                    break;
                }

        }
        nigga.close();
    }

}
