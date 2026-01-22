import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncontrarCosas {

    public static void main(String[] args) {

        boolean salir = false;
        int iterador = 1;

        do {

            try (BufferedReader leerBufer = new BufferedReader(new FileReader("carpeta/prob1/archivo.txt"))) {

                String linea = "";

                if (iterador == 1) {

                    System.out.println("Correos encontrados: ");
                    while ((linea = leerBufer.readLine()) != null) {

                        Matcher matcherCorreo = Pattern.compile("\\S*[A-Za-z0-9#$&\\w]+@[A-Za-z0-9]+\\.[A-Za-z]{2,}\\S*").matcher(linea);

                        while (matcherCorreo.find()) {

                            System.out.println(matcherCorreo.group());

                        }

                    }


                } else if (iterador == 2) {

                    System.out.println("Contraselas válidas encontradas: ");
                    while ((linea = leerBufer.readLine()) != null) {

                        Matcher matcherPasswd = Pattern.compile("(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*[^A-Za-z\\d\\s])\\S{8,}").matcher(linea);
                        while (matcherPasswd.find()) {

                            System.out.println(matcherPasswd.group());

                        }

                    }

                } else {

                    System.out.println("Fin del programa...");
                    break;

                }

                iterador++;
            } catch (FileNotFoundException e) {

                System.out.println("Archivo NO encontrado !!!");

            } catch (IOException e) {

                System.out.println("Error en la lectura del archivo !!!");

            }
            System.out.println("---------------------------------------------");

        } while (!salir);



    }

}
