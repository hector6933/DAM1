public class Ejercicio17 {

    public static String quitarEspacios(String frase) {

        StringBuilder sinEspacios = new StringBuilder(frase);

        int longitud = frase.length();
        for (int i = 0; i < longitud; i++) {

            if (sinEspacios.charAt(i) == ' ') {

                sinEspacios.deleteCharAt(i);
                longitud--;

            }

        }

        return sinEspacios.toString();
    }

    public static void main() {

        String frase = "Hola que tal estamos";

        System.out.println(quitarEspacios(frase));

    }

}
