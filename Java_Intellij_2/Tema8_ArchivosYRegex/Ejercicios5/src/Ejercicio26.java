import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio26 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        boolean correcto = false;
        int palabras = 0;
        String usuInput = "";

        do {

            try {

                System.out.println("Introduce la longitud de las palabras a buscar: ");
                System.out.print("> ");
                usuInput = leer.nextLine();

                palabras = Integer.parseInt(usuInput);

                if (palabras <= 0) {

                    System.out.println("La longitud de la palabra debe ser mayor a 0 !!!");

                } else {

                    correcto = true;

                }

            } catch (Exception e) {

                System.out.println("Introduce un número válido !!!");
                try (BufferedWriter escribirBufer = new BufferedWriter(new FileWriter("carpeta/Ej26/erroresUsuarioLog.txt", true))) {

                    LocalTime hora = LocalTime.now().withNano(0);
                    escribirBufer.write(LocalDate.now().toString() + " " + hora + " --> " + usuInput);
                    escribirBufer.newLine();

                } catch (FileNotFoundException e2) {

                    System.out.println("Archivo NO encontrado !!!");

                } catch (IOException e2) {

                    System.out.println("Error en la escritura del archivo !!!");

                }

            }

        } while (!correcto);

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej26/archivo.txt"))){

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                Matcher patronLongitud = Pattern.compile("\\b[\\w]{" + palabras + "}\\b").matcher(linea);

                while (patronLongitud.find()) {

                    System.out.println("Palabra encontrada: " + patronLongitud.group());

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

        leer.close();

    }

}
