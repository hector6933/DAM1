import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) throws IOException {

        Scanner leer = new Scanner(System.in);

        System.out.println("Introduce la ruta del fichero: ");
        System.out.print("> ");

        Path miRuta = Paths.get(leer.next());

        File miArchivo = new File(miRuta.toString());

        if (miArchivo.exists()) {

            System.out.println("Directorio raiz del sistema de archivos que contiene el archivo: " + miRuta.getRoot());
            System.out.println("Directorio donde se encuentra el archivo: " + miRuta.getParent().toString().substring(miRuta.getParent().toString().lastIndexOf("\\") + 1));
            System.out.println("Nombre del archivo: " + miRuta.getFileName());
            System.out.println("Extensión del archivo: " + miRuta.getFileName().toString().substring(miRuta.getFileName().toString().indexOf(".")));

        } else {

            System.out.println("El fichero NO existe");

        }



    }

}
