import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio24Regex {

    public static void main(String[] args) {

        try (BufferedWriter writeBufer = new BufferedWriter(new FileWriter("carpeta/Ej24_2/archivo2.txt"));
            BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/Ej24_2/archivo.txt"))) {

            String linea;
            int contLinea = 0;
            while ((linea = leerBufer.readLine()) != null) {

                StringBuilder regex = new StringBuilder();
                StringBuilder regex2 = new StringBuilder();

                Matcher matcherPalabras = Pattern.compile("\\S*[\\S]+\\S*").matcher(linea);

                int contadorPalabras = 0;


                while (matcherPalabras.find()) {

                    contadorPalabras++;

                }

                for (int i = 0; i < contadorPalabras; i++) {

                    if (i == contadorPalabras-1) {

                        regex.append("(\\S*[\\w]+\\S*)");

                    } else {

                        regex.append("(\\S*[\\w]+\\S*) ");

                    }

                }

                for (int i = contadorPalabras; i > 0; i--) {

                    if (i == 1) {

                        regex2.append("$" + i);

                    } else {

                        regex2.append("$" + i + " ");

                    }

                }

                String linea2 = linea.replaceAll(regex.toString(),regex2.toString());

                System.out.println("Linea: " + linea2);
                System.out.println("---------------------------");
                writeBufer.write(linea2);
                writeBufer.newLine();

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
