import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EncontrarCosas {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/prob1/archivo.txt"))) {

            String linea;

            while ((linea = leerBufer.readLine()) != null) {



            }


        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }


    }

}
