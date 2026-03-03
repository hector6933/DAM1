import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ejercicio4 {

    public static void main(String[] args) {

        // Me creo el mapa de las palabras que voy a almacenar
        HashMap<String,Integer> mapa = new HashMap<>();

        // Creo la conexión con el archivo de texto para leerlo
        try (BufferedReader leerBufer = new BufferedReader(new FileReader("Metadata in DBMS.txt"))) {

            String linea;
            while ((linea = leerBufer.readLine()) != null) {

                // Me creo un array de palabras para cada línea del fichero y las voy introduciendo en el mapa
                for (String e : linea.toLowerCase().split("[^A-Za-z]+")) {

                    if (!e.isEmpty()) {

                        mapa.put(e, mapa.containsKey(e) ? mapa.get(e.toLowerCase()) + 1 : 1);

                    }
                }

            }

        } catch (FileNotFoundException e) {

            System.out.println("Archivo NO encontrado !!!");

        } catch (IOException e) {

            System.out.println("Error en la lectura del archivo !!!");

        }

        // Compruebo las 3 palabras más frecuentes mediante la forma que se me ha ocurrido
        System.out.println("Las 3 palabras más frecuentes: ");

        // Hago un for each de todos los valores del mapa ordenados de mayor a menor

        ArrayList<Map.Entry<String, Integer>> lista = new ArrayList<>(mapa.entrySet());

        lista.sort(Map.Entry.comparingByValue());

        System.out.println(lista.reversed());

//        int i = 1;
//        for (Integer e: mapa.values().stream().sorted(Comparator.reverseOrder()).toList()) {
//
//            // Hago otro for each de todas las claves del mapa
//            for (String s: mapa.keySet()) {
//
//                // En caso de que el valor correspondiente sea el mismo que el de la clave correspondiente lo saco por pantalla y lo elimino del mapa para evitar que se repita la siguiente vez
//                if (mapa.get(s).equals(e)) {
//
//                    System.out.println(i + " - " + s + " " + mapa.get(s) + " veces");
//                    mapa.remove(s);
//                    i++;
//                    break;
//                }
//
//            }
//
//            if (i == 4) {
//
//                break;
//
//            }
//
//        }

    }

}
