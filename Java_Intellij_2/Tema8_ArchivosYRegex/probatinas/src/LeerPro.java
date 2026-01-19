import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeerPro {

    public static void main(String[] args) {

        try {

            String texto = Files.readString(Path.of("carpeta/alonso/archivo.txt"));
            int contador = 0;
            for (int i = 0; i < texto.length(); i++) {

                if (texto.toLowerCase().charAt(i) == 'a') {

                    contador++;

                }

            }
            System.out.println("En total hay " + contador + " As");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }
    }


}
