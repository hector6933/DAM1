import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CosasString {

    public static void main() {

        // Se puede meter un array de char en una variable de tipo string

        char[] letras = {'H','o','l','a',' ','q','u','e',' ','t','a','l'};
        String palabra = new String(letras);

        for (int i = 0; i < palabra.length(); i++) {

            if (i > 8) continue;
            System.out.println(palabra.charAt(i));

        }

        // Se puede concantar strings con .concat

        String pascual = "Pascual";

        System.out.println(palabra.concat(" " + pascual));

        // Para buscar un texto en una cadena:

        String infoJava = "Java es un lenguaje de programación y una plataforma informática que fue comercializada por primera vez en 1995 por Sun Microsystems.[2]\u200B[3]\u200B\n" +
                "\n" +
                "El lenguaje de programación Java fue desarrollado originalmente por James Gosling, de Sun Microsystems (constituida en 1983 y posteriormente adquirida el 27 de enero de 2010 por la compañía Oracle),[4]\u200B y publicado en 1995 como un componente fundamental de la plataforma Java de Sun Microsystems. Su sintaxis deriva en gran medida de C y C++, pero tiene menos utilidades de bajo nivel que cualquiera de ellos. Las aplicaciones de Java son compiladas a bytecode (clase Java), que puede ejecutarse en cualquier máquina virtual Java (JVM) sin importar la arquitectura de la computadora subyacente.";

        System.out.println(infoJava.contains("Java")); // Con .contains me busca la palabra exacta, diferenciando entre mayúsculas y minúsculas

        // Aquí busco la 'e' empezando por el principio
        System.out.println(infoJava.indexOf('e')); // indexOf también distingue entre mayúsculas y minúsculas

        // Y ahora busco la segunda 'e' también empezando por el principio
        System.out.println(infoJava.indexOf('e',infoJava.indexOf('e')+1 ));

        System.out.println(infoJava.lastIndexOf('e')); // Busco la primera 'e' empezando por el final

        // Para obtener subStrings de una cadena

        String juanma = "Ahora viene cuando la matan";
        System.out.println(juanma.substring(0,5)); // El segundo número indica hasta que carácter va a coger, osea el que le indiquemos NO lo coge, por eso hay que hacer 1 más
        System.out.println(juanma.substring(19));

        // Dividir el texto con condiciones

        String[] palabrasInfoJava = infoJava.split(" "); // Este metodo mete en un array las cadenas separadas por la cadena que le pases por parámetro
        // La cadena pasada por parámetro se eliminará al almacenar las cadenas en el array.

//        for (String palabras : palabrasInfoJava) {
//
//            System.out.println(palabras);
//
//        }

        palabrasInfoJava = infoJava.split(","); // Ahora le indico que me lo separe por ',' osea por frases

        for (String palabras : palabrasInfoJava) {

            System.out.println(palabras.trim()); // El metodo .trim() elimina los espacios del principio y final de la cadea

        }

        System.out.println();
        // Con '.replace' indicamos el carácter a reemplazar y luego el carácter por el que queremos reemplazarlo
        System.out.println("Mi moto alpina de repente".replace('i','e').replace('o','e').replace('a','e'));

        // También se pueden reemplazar cadenas
        System.out.println("Como toser y tomarse un caramelo para la tos".replace("tomarse un caramelo para la tos","rascarse la barriga"));

        // Podemos determinar si una cadena empieza o termina por una cadena en concreto

      //  String payo = "+34 568 23 626 23";
        String payo = "+51 234 56 58 09";

        if (payo.startsWith("+34")) {

            System.out.println("Es payo");

        } else if (payo.startsWith("+51")) {

            System.out.println("PANCHITOOOOO");

        } else {

            System.out.println("pff ni idea");

        }

        String hector = "Me gustan las tetas";
        String pablo = "Adoro las tetas";
        String gay = "A mi me gustan las pololas";

        String[] tetas = new String[3];
        tetas[0] = hector;
        tetas[1] = pablo;
        tetas[2] = gay;

        boolean tetacas = true;
        for (String palabras : tetas) {

            if (!palabras.endsWith("tetas")) {

                tetacas = false;
                break;

            }

        }

        if (tetacas) {

            System.out.println("Conclusión: tetas");

        } else {

            System.out.println("Conclusión: no tetas");

        }

        // Para comprobar si en Ascii es mayor una cadena u otra

        // Al poner el símbolo comparas la devolución del metodo
        // El metodo devuelve -1 si x es menor que y
        // El metodo devuelve 0 si x es igual a y
        // El metodo devuelve 1 si x es meyor que y
        System.out.println("A".compareTo("B")<0); // Aquí el metodo devuelve -1 ya que A es menor que B
        System.out.println("X".compareTo("X")); // Aquí el metodo devuelve 0 ya que X es igual a X
        System.out.println("C".compareTo("B")); // Aqui el metodo devuelve 1 ya que C es mayor que B

        // Convertir de otros tipos a String

        int numerin = 2500;
        double numerinD = 33.67;
        boolean siONo = false;

        String[] cositas = new String[3];
        cositas[0] = String.valueOf(numerin);
        cositas[1] = String.valueOf(numerinD);
        cositas[2] = String.valueOf(siONo);

        for (String palabras : cositas) {

            System.out.print(palabras + " ");

        }

        System.out.println();
        // StringBuilder
        // Este tipo de datos es como un wrapper de String, es mejor
        StringBuilder miSuperString = new StringBuilder("Hola que tal estamos");

        miSuperString.setCharAt(0,'J'); // Reemplazar un carácter
        miSuperString.append(" !!!"); // Añadir carácteres o cadenas
        miSuperString.insert(12," no"); // Inserta el texto detrás del carácter que le indiques
        miSuperString.replace(13,miSuperString.length(),"x"); // Reemplaza una cadena desde una poscion hasta otra por otra cadena
        miSuperString.append("?");

        System.out.println(miSuperString);

        miSuperString.reverse(); // Metodo para hacer un reverse de la cadena

        System.out.println(miSuperString);


        Integer intagah = 55;
        int intNormal = intagah;

        System.out.println(intagah);
        System.out.println(intNormal);

        // ArrayList

        ArrayList<Integer> numerosInteger = new ArrayList<>();

        for (int i = 0; i < 500; i++) {

            numerosInteger.add((int) (Math.random() * (200 - 100 + 1)) + 100);

        }

        System.out.println();

        System.out.println("Desordenado: ");
        for (int numerines : numerosInteger) {

            System.out.print(numerines + " ");

        }

        System.out.println();
        Collections.sort(numerosInteger);

        System.out.println("Ordenado: ");

        for (int numerines : numerosInteger) {

            System.out.print(numerines + " ");

        }

        System.out.println();
        System.out.println();

        // Para ordenar arrays por orden alfábetico:

        ArrayList<String> ciudades = new ArrayList<>();
        ciudades.add("Teruel");
        ciudades.add("Zaragoza");
        ciudades.add("Valencia");
        ciudades.add("Madrid");

        Collections.sort(ciudades);

        System.out.println("Ciudades ordenadas: ");
        for (String palabras : ciudades) {

            System.out.println(palabras);

        }
        System.out.println();
        // Imagina que te piden el orden reverso del alfabeto
        // Pues lo ordenas y le haces un reverse

        Collections.reverse(ciudades);

        System.out.println("Ciudades DESordenadas: ");
        for (String palabras : ciudades) {

            System.out.println(palabras);

        }

    }

}
