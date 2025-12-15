import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio3 {

    public static void main(String[] args) throws IOException {

        Path ruta1 = Paths.get("hola");

        Files.createDirectory(ruta1);

    }

}
