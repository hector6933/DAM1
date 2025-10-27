public class Ejercicio31 {

    public static void main(String[] args) {

        int max = 100;
        int min = 1;
        int random;
        int mayor = 1;
        int menor = 100;
        for (int i = 0; i < 100; i++) {

            random = (int) (Math.random() * (max - min) + min);
            System.out.println(random);
            if (random > mayor) {

                mayor = random;

            }
            if (random < menor) {

                menor = random;

            }

        }
        System.out.println("El número más grande es " + mayor + " y el menor " + menor);


    }

}
