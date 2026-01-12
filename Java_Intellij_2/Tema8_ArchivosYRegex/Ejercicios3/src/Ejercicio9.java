import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio9 {

    public static void main(String[] args) {


        try (BufferedReader leer = new BufferedReader(new FileReader("carpeta/Ej9/archivo.txt"))){

            String linea;

            while ((linea = leer.readLine()) !=null)  {

                Matcher patronCorreo = Pattern.compile("[\\w.%+]+@[a-zA-Z]+\\.[a-zA-Z]+\\.[a-zA-Z]{2,}").matcher(linea);

                Matcher patronCodigoPostal = Pattern.compile("\\b[0-9]{5}\\b").matcher(linea);

                Matcher patronTelefono = Pattern.compile("\\bTeléfono: [0-9]{3} [0-9]{2} [0-9]{2} [0-9]{2}\\b").matcher(linea);

                Matcher patronWeb = Pattern.compile("[w]{3}\\.[a-zA-Z]+\\.[a-zA-Z]{2,}").matcher(linea);

                if (patronCorreo.find()) {

                    System.out.println("Encontrado el Correo electrónico: " + patronCorreo.group());

                }

                if (patronCodigoPostal.find()) {

                    System.out.println("Encontrado el Código postal: " + patronCodigoPostal.group());

                }

                if (patronTelefono.find()) {

                    System.out.println("Encontrado el " + patronTelefono.group());

                }

                if (patronWeb.find()) {

                    System.out.println("Encontrado la Dirección web: " + patronWeb.group());

                }
            }


        } catch (FileNotFoundException e) {

            System.out.println("Error, archivo NO encontrado !!!");

        } catch (IOException e) {


            System.out.println("Error en la lectura del archivo !!!");

        }

    }

}
