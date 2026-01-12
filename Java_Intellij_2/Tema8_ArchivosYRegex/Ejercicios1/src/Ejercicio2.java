import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce la ruta de un directorio: ");
        System.out.print("> ");

        Path ruta1 = Paths.get(leer.next());
        leer.nextLine();

        File fichero = new File(ruta1.toString());

        if (fichero.exists()) {

            System.out.println("El directorio padre es: " + ruta1.getParent().toString().substring(ruta1.getParent().toString().lastIndexOf("\\") + 1));
            if (ruta1.toString().contains(".")) {

                System.out.println("Se trata de un fichero");

            } else {

                System.out.println("Se trata de un directorio");

                for (File e : fichero.listFiles()) {

                    System.out.println(e.toString());

                }

            }

        } else {

            System.out.println("El fichero NO existe");

        }


    }

}
