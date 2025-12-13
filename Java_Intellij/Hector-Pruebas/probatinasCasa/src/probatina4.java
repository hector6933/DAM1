import java.util.Arrays;

public class probatina4 {

    public static void main(String[] args) {

        int[] a = {1,2,3};
        int[] b = {4,5,6};
        int[] c = Arrays.copyOf(a,6);
        int[] randoms = new int[500];

        System.arraycopy(b,0,c,3,1);
        System.out.println(c.length);

        System.out.println(Arrays.toString(c));

        int[] d = Arrays.copyOfRange(b,1,3);

        System.out.println(Arrays.toString(d));

        System.out.println(Arrays.binarySearch(c,3));

        for (int i = 0; i < 500; i++) {

            randoms[i] = (int) (Math.random() * 101);

        }

        Arrays.sort(randoms);
        System.out.println(Arrays.binarySearch(randoms,50));
        System.out.println(randoms[Arrays.binarySearch(randoms,50)]);

        String cadenaUsuario = "Hola que tal";
        StringBuilder cadenaUsuarioAlReves = new StringBuilder(cadenaUsuario);
        cadenaUsuarioAlReves.reverse();
        System.out.println(cadenaUsuarioAlReves);

        char[] caracteres = {'h','o','l','a'};
        String cadenaDeCaracteres = new String(caracteres);
        System.out.println(cadenaDeCaracteres);

        System.out.println("--------------------------");
        String cadenaPrueba = "Pascual";

        char[] prueba = new char[cadenaPrueba.length()];

        cadenaPrueba.getChars(0,cadenaPrueba.length(),prueba,0);

        System.out.println(Arrays.toString(prueba));

        System.out.println("--------------------------");

        String cadena1 = "Iker";
        String cadena2 = "madura";
        System.out.println(cadena1.concat(" " + cadena2));

        String pascual2 = "Hola que tal estás Pascual??";

        System.out.println(pascual2.lastIndexOf('e'));


        String juanma = "Ayer estaba paseando a la mosca cojonera cuando de repente me dio una tos terrible, y bueno, me tuve que rascar la barriga";

        System.out.println(juanma.contains("mosca"));

        System.out.println(juanma.substring(26,40));

        System.out.println(juanma.substring(0,4));

        String holaMundo = "Hello world!";
        System.out.println(holaMundo.replace("Hello", "Bye, bye,"));
        System.out.println("gobernment".replace('b','v'));

        StringBuilder cadena = new StringBuilder("Buenas que tal estamos?");

        cadena.replace(0,2,"v");
        System.out.println(cadena);


        int entero = 33;

        // Autoboxing
        Integer Entero = entero;

        // Unboxing
        int entero2 = Entero;


    }

}
