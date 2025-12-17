import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio3 {

    public static void main(String[] args){

        // Recordatorio
        // Dejar RO_UD08_EJ03/ con solo el archivo Programacion.txt

        Path ruta1 = Paths.get("carpeta/PRO_UD08_EJ03/Programacion.txt");
        Path ruta2 = Paths.get("carpeta/PRO_UD08_EJ03/Programacion(+1).txt");
        Path ruta3 = Paths.get("carpeta/PRO_UD08_EJ03/Programacion(+2).txt");
        Path ruta4 = Paths.get("carpeta/PRO_UD08_EJ03/docs/samples");
        Path ruta5 = Paths.get("carpeta/PRO_UD08_EJ03/docs/exercises");
        Path ruta6 = Paths.get(ruta4.toString() + "/Programacion.txt");
        Path ruta7 = Paths.get(ruta5.toString() + "/Programacion.txt");

        File fichero1 = new File(ruta1.toString());

        // Intentar copiar el archivo de "Programacion.txt" dos veces
        try {

            Files.copy(ruta1,ruta2);
            Files.copy(ruta1,ruta3);

        } catch (IOException e) {

            System.out.println("Ha ocurrido un error al copiar los ficheros !!!");

        }

        // Intentar crear una estructura de carpetas
        try {

            Files.createDirectories(ruta4);
            Files.createDirectory(ruta5);


        } catch (IOException e) {

            System.out.println("Ha ocurrido un error al crear la estructura de carpetas !!!");

        }

        // Intentar copiar el archivo "Programacion.txt" en la carpeta PRO_UD08_EJ03/docs/samples

        try {

            Files.copy(ruta1,ruta6);

        } catch (IOException e) {

            System.out.println("Ha ocurrido un error al copiar !!!");

        }

        // Intentar mover el archivo Progrmacion.txt a la carpeta exercises

        try {

            Files.move(ruta1,ruta7);

        } catch (IOException e) {

            System.out.println("Ha ocurrido un error al mover el arhcivo");

        }

        // Intentar renombrar el fichero "Programacion(+1).txt como "Programacion.txt""

        try {

            Files.move(ruta2,ruta1);

        } catch (IOException e) {

            System.out.println("Ha ocurrido un error al intentar renombrar el archivo !!!");

        }

        // Intentar borrar el archivo "Programacio(+2).txt"

        try {

            Files.delete(ruta3);

        } catch (IOException e) {

            System.out.println("Ha ocurrido un error al intentar borrar el arhcivo !!!");

        }

    }

}
