import java.util.Scanner;
public class Ejercicio2 {

    public static void main() {

        Scanner leer = new Scanner(System.in);

        boolean correcto = false;
        int num;
        char letra;
        do {

            System.out.println("Introduce un número entre 65-90 o 97-122: ");
            System.out.print("> ");
            if (leer.hasNextInt()) {

                num = leer.nextInt();
                leer.nextLine();
                if ( (num >= 65 && num <= 90) || (num >=97 && num <=122) ) {

                    letra = (char) num;
                    
                    if (letra == 'a' || letra == 'A' || letra == 'e' || letra == 'E' || letra == 'i' || letra == 'I' || letra == 'o' || letra == 'O' || letra == 'u' || letra == 'U') {

                        System.out.println("La letra es " + letra + " y es una vocal");
                        
                    } else {

                        System.out.println("La letra es " + letra + " y NO es una vocal");
                        
                    }
                    
                    correcto = true;

                } else {

                    System.out.println("Debes de introducir un número entre los rangos 65-90 o 97-122");

                    
                }


            } else {

                System.out.println("Número inválido, debes introducir un número entero !!!");
                leer.nextLine();

            }

        } while (!correcto);

    }

}
