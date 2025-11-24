import java.sql.SQLOutput;

public class ArrayCharEnString {

    public static void main(String[] args) {

        char[] letras = {'H','o','l','a',' ','q','u','e',' ','t','a','l'};
        String palabra = new String(letras);
        System.out.println(palabra);

        String palabra2 = " estás?";

        String palabra3 = palabra.concat(palabra2);

        System.out.println(palabra3);

        int a = 33;
        float b = 10.5467f;
        String c = "Texto";
        System.out.println(String.format("El valor de a es %s" + "\nEl valor del doble es %f",c,b));

        String textoGrande = "dadawdawawsdawsdwaBrevaasddssdssaasasasasadsawwdwdaasdawdawsawddwadwdawmdaPablodasdadawmkmmoomPascual";

        System.out.println("Contiene \"breva\"? (Ignorando las mayúsculas): " + textoGrande.contains("BrEvA"));
        System.out.println("Contiene \"breva\"? (SIN ignorar las mayúsculas): ");
        System.out.println("");

        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus tellus nunc, pellentesque vel commodo ac, lobortis nec tortor. Praesent quis ligula cursus, rhoncus velit id, vehicula arcu. Integer facilisis ipsum eu bibendum dictum. Integer ipsum nunc, iaculis et ex sed, aliquam ornare velit. In hendrerit metus quis orci egestas, vel accumsan mauris efficitur. Vivamus malesuada elementum magna, eget auctor mauris tincidunt nec. Praesent pulvinar orci finibus suscipit fringilla. Curabitur vulputate eu tellus eget gravida. Duis varius turpis vitae dolor pulvinar, sed porta eros fringilla. Ut sed feugiat dui. Nunc nec augue a quam sollicitudin ornare malesuada id arcu. Aliquam elementum. ";

        System.out.println("------------------------------------");
        System.out.println("Palabras del lorem: ");
        System.out.println("------------------------------------");
        String[] palabrasLorem = loremIpsum.split(" ");
        for (String palabras : palabrasLorem) {

            System.out.println(palabras);

        }

        System.out.println("------------------------------------");
        System.out.println("Frases del lorem (eliminando espacios delante o detrás de las cadenas): ");
        System.out.println("------------------------------------");
        String[] frasesLorem = loremIpsum.split(",");
        for (String frases : frasesLorem) {

            System.out.println(frases.trim());

        }

        System.out.println();
        System.out.println("Reemplazo Hola por Adios, en la cadena \"Hola mundo !\" (En caso de que esté y sin ignorar mayúsculas):");
        System.out.println("------------------------------------");

        String cadenaHolaMundo = "Hola mundo !";
        System.out.println(cadenaHolaMundo.replace("Hola","Adios"));

        System.out.println();
        System.out.println("Reemplazo b por v, en la cadena \"Buenos días, buenas noches\" (En caso de que esté y sin ignorar mayúsculas):");
        System.out.println("------------------------------------");
        System.out.println("Buenos días, buenas noches".replace('b','v'));

        System.out.println();
        System.out.println("Reemplazo b por v, en la cadena \"Buenos días, buenas noches\" (En caso de que esté y ignorando mayúsculas):");
        System.out.println("------------------------------------");
        System.out.println("Buenos días, buenas noches".toLowerCase().replace('b','v'));

        System.out.println();
        System.out.println("Comparar que cadenas son mayores en cuento al orden ASCII:");

        System.out.print("\"A\".compareTo(\"B\")<0 --> ");
        System.out.println("A".compareTo("B")<0);

        System.out.print("\"B\".compareTo(\"B\")==0 --> ");
        System.out.println("B".compareTo("B")==0);

        System.out.print("\"C\".compareTo(\"B\")>0 --> ");
        System.out.println("C".compareTo("B")>0);

        StringBuilder cadena1 = new StringBuilder();
        StringBuilder cadena2 = new StringBuilder(50);
        StringBuilder cadena3 = new StringBuilder("Hola que tal");
        cadena3.append(" estas?");
        System.out.println(cadena3);

        cadena3.deleteCharAt(cadena3.length()-1);
        System.out.println(cadena3);

        cadena3.setCharAt(cadena3.length()-1,'n');
        System.out.println(cadena3);

        System.out.println();
        System.out.println("Parámetros del programa: ");
        if (args.length == 0) {

            System.out.println("Este programa NO tiene argumentos");

        } else {

            for (String cosas : args) {

                System.out.println(cosas);

            }

        }


    }

}
