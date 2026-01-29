package repasoArchivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeerBytes {

    public static void main(String[] args) {

        try (FileInputStream leerBytes = new FileInputStream("carpeta/repaso/repaso1.txt")){

            int dataByte;
            System.out.println("Contenido del archivo:");
            while ((dataByte = leerBytes.read()) != -1) {

                System.out.print((char) dataByte);

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error el la lectura del archivo !!!");

        }

    }

}
