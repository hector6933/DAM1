package Repaso.PracEvaluable10y11;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Ej4 {

    public static void main(String[] args) {

        HashMap<String,Integer> mapa = new HashMap<>();

        try (BufferedReader leerBufer = new BufferedReader(new FileReader("Metadata in DBMS.txt"))) {

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                for (String e : linea.toLowerCase().split("[^A-Za-z]+")) {

                    if (!e.isEmpty()) {

                        mapa.put(e, mapa.containsKey(e) ? mapa.get(e) + 1 : 1);

                    }

                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");
            e.printStackTrace();

        }

        ArrayList<Map.Entry<String,Integer>> palabras = new ArrayList<>(mapa.entrySet());

        palabras.reversed().sort(Map.Entry.comparingByValue());

        System.out.println("Las 3 palabras más frecuentes: ");
        palabras.stream().limit(3).forEach(System.out::println);


    }

}
