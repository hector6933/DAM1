import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class leerBytes {

    public static void main(String[] args) {

        try (FileInputStream leerBytes = new FileInputStream("carpeta/prob1/archivo2.txt")) {

            int numByte;
            while ((numByte = leerBytes.read()) != -1) {

                System.out.print((char) numByte);

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
