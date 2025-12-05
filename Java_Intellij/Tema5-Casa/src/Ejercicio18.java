public class Ejercicio18 {

    public static String[] palabrasEnArray(String frase) {

        String[] palabras = new String[frase.length()];

        palabras = frase.split(" ");

        return palabras;
    }


    public static void main(String[] args) {

        String frase = "Hola mundo que tal estamos";

        String[] probar = palabrasEnArray(frase);

        for (String palabras : probar) {

            System.out.println(palabras);

        }

    }

}
