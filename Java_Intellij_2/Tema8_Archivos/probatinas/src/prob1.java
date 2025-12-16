import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class prob1 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        boolean salir = false;
        int opcion = 0;
        String nombreCarpeta;

        do {

            System.out.println("¿Que quieres hacer?");
            System.out.println("1 - Crear una carpeta");
            System.out.println("2 - Crear una sucesion de carpetas");
            System.out.print("> ");
            try {

                opcion = Integer.parseInt(leer.nextLine());
                salir = true;

            } catch (NumberFormatException e) {

                System.out.println("Opción inválida !!!");

            }

        } while (!salir);
        boolean comprobar;
        do {
            comprobar = true;
            switch (opcion) {

                case 1:
                    boolean correcto;
                    do {
                        correcto = true;
                        System.out.println("Dime el nombre de la carpeta, (solo carácteres del alfabeto):");
                        System.out.print("> ");
                        nombreCarpeta = leer.next();
                        leer.nextLine();
                        for (int i = 0; i < nombreCarpeta.length(); i++) {

                            if (!(nombreCarpeta.toLowerCase().charAt(i) >= 'a' && nombreCarpeta.toLowerCase().charAt(i) <= 'z'))  {

                                System.out.println("El nombre de la carpeta contiene al menos un carácter ilegal !!!");
                                correcto = false;
                                break;

                            }

                        }

                    } while (!correcto);

                    Path ruta1 = Paths.get("carpeta/" + nombreCarpeta);

                    try {

                        Files.createDirectory(ruta1);
                        System.out.println("Carpeta creada correctamente en: " + ruta1.toAbsolutePath());

                    } catch (IOException e) {

                        System.out.println("Error al crear el arhcivo !!!");

                    }
                    break;
                case 2:

                    break;
                default:
                    System.out.println("Opcion inválida !!!");
                    comprobar = false;
                    break;

            }
        } while (!comprobar);






    }

}
