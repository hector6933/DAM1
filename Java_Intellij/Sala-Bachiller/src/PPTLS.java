import  java.util.Arrays;
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

    public static boolean partidaHumanovsHumano(String jugador1, String judaor2) {

        boolean correcto;
        byte opcion = 0;
        byte eleccion1 = 0;
        byte eleccion2 = 0;
        int i = 1;

        do {
            correcto = false;
            System.out.println("Turno del jugador" + i);
            System.out.println("Elige: ");
            System.out.println("1 - Piedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tijera");
            System.out.print("> ");
            if (leer.hasNextByte()) {

                opcion = leer.nextByte();

            }
            leer.nextLine();
            switch (opcion) {

                case 1:
                    if (i == 1) {

                        eleccion1 = 1;

                    } else {

                        eleccion2 = 1;
                        correcto = true;

                    }
                    i++;
                case 2:
                    if (i == 1) {

                        eleccion1 = 2;

                    } else {

                        eleccion2 = 2;
                        correcto = true;

                    }
                    i++;
                    break;

                case 3:
                    if (i == 1) {

                        eleccion1 = 3;

                    } else {

                        eleccion2 = 3;
                        correcto = true;

                    }
                    i++;
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;

            }


        } while (!correcto);

        if (eleccion1 == 1 && eleccion2 == 3) {

            return true;

        } else if (eleccion1 == 1) {

        }


    }

    }

    public static void jugar() {

        byte opcion = 0;
        String jugador1;
        String jugador2;
        boolean correcto;
        boolean salir;
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

                    System.out.println("El primero que llegue a 3 puntos gana: ");
                    esperar(0.5);
                    do {
                        salir = false;
                        partidaHumanovsHumano(jugador1, jugador2);


                    } while (!salir);
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
