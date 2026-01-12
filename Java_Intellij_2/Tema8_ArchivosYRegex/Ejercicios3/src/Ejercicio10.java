import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio10 {

    public static void encontrarPatron(String patron) {

        try (BufferedReader leer = new BufferedReader(new FileReader("carpeta/Ej10/DATA - DATA.csv"))) {

            String linea;

            while ((linea = leer.readLine()) != null) {

                Matcher pais = Pattern.compile(patron).matcher(linea);

                if (pais.find()) {

                    System.out.println(linea);

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

    }

    public static void main(String[] args) {

//        System.out.println("-----------------------------------------------");
//        System.out.println("Registros de los paises Portugal y España:");
//        encontrarPatron("\\bES\\b|\\bPT\\b");
//        System.out.println("-----------------------------------------------");
//        System.out.println();
//
//        System.out.println("-----------------------------------------------");
//        System.out.println("Registros con email de dominios .edu:");
//        encontrarPatron(",[a-zA-Z]+@[a-zA-Z]+\\.edu,");
//        System.out.println("-----------------------------------------------");
//        System.out.println();
//
//        System.out.println("-----------------------------------------------");
//        System.out.println("Registros con email de yahoo:");
//        encontrarPatron(",[a-zA-Z]+@yahoo");
//        System.out.println("-----------------------------------------------");
//        System.out.println();

        System.out.println("-----------------------------------------------");
        System.out.println("Registros con el último login entre mayo de 2015 y febrero de 2017:");
        encontrarPatron(",2015-0[5-9]-|,2015-[10-12]-|,2016-[0-9]{2}-|,2017-0[0-2]-");
        System.out.println("-----------------------------------------------");

    }

}
