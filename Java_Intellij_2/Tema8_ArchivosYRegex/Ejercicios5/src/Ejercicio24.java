import java.io.*;

public class Ejercicio24 {

    public static void main(String[] args) {

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej24/archivo.txt"));
             BufferedWriter writeBufer = new BufferedWriter(new FileWriter("carpeta/Ej24/archivo2.txt"))) {

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                StringBuilder lineaTemp = new StringBuilder(linea);
                lineaTemp.reverse();
                writeBufer.write(lineaTemp.toString() + "\n");

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura / escritura del archivo !!!");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

}
