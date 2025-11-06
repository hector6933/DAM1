import java.util.Arrays;
import java.util.Scanner;

public class PPTLS {

    static Scanner leer = new Scanner(System.in);

    public static void esperar(double mili) {

        int seg = (int) mili * 1000;
        try {

            Thread.sleep(seg);

        } catch (InterruptedException e) {

            throw new RuntimeException(e);

        }



    }

    public static void partidaHumanovsHumano(String jugador1, String jugador2) {

        boolean correcto;
        System.out.println("Turno de " + jugador1);
        do {
            correcto = false;

        } while (!correcto);
        System.out.println("Elige");


    }

    public static void jugar() {

        byte opcion = 0;
        String jugador1;
        String jugador2;
        boolean correcto;
        System.out.println("Partida simple");
        esperar(0.3);
        do {
            correcto = true;
            System.out.println("Elige: ");
            System.out.println("1 - Humano VS Humano");
            System.out.println("2 - Humano VS BOT");
            System.out.print("> ");
            if (leer.hasNextByte()) {

                opcion = leer.nextByte();

            }
            leer.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Introduce el nombre del jugador 1");
                    jugador1 = leer.next();
                    System.out.println("Introduce el nombre del jugador 2");
                    jugador2 = leer.next();
                    partidaHumanovsHumano(jugador1, jugador2);
                    break;
                case 2:
                    System.out.println("BOT");
                    break;
                default:
                    System.out.println("¡ Opción inválida !");
                    correcto = false;
                    break;
            }

        } while (!correcto);



    }

    public static void main(String[] args) {

        // Piedra papel tijera de toa la vida.

        boolean salir;
        boolean correcto;
        byte opcion = 0;
        System.out.println("Bienvenido al piedra papel tijera DE TODA LA VIDA ☻");
        esperar(0.7);
        do {
            salir = true;
            System.out.println("Elige:");
            System.out.println("1 - Jugar");
            System.out.println("2 - Reglas");
            System.out.println("3 - Torneo");
            System.out.println("4 - Salir");
            System.out.print("> ");
            if (leer.hasNextByte()) {

                opcion = leer.nextByte();
                correcto = true;

            }
            leer.nextLine();

            switch (opcion) {

                case 1:
                    jugar();
                    break;
                case 2:
                    System.out.println("Reglas");
                    break;
                case 3:
                    System.out.println("Torneo");
                    break;
                case 4:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("¡ Opción inválida !");
                    salir = false;
                    break;
            }

        } while (!salir);

        leer.close();

    }

}
