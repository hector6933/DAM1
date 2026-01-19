import java.io.*;

public class LeerNormal {

    public static void main(String[] args) {

        try (FileReader leer = new FileReader("carpeta/alonso/archivo.txt")) {

            int letra;
            int contador = 0;
            while ((letra = leer.read()) != -1) {

                System.out.print((char) letra);

                if (letra == 'a' || letra == 'A') {

                    contador++;

                }

            }
            System.out.println();

            System.out.println("En total hay " + contador + " As");

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }
    }


}
