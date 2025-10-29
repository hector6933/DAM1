import java.util.Scanner;
public class BlackJack {

    static Scanner leer = new Scanner(System.in);

    public static void esperar(double sec) {

        int T = (int) (sec * 1000);

        try {

            Thread.sleep(T);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void reglas() {

        System.out.println("Reglas básicas: ");
        esperar(0.5);
        System.out.println("- El objetivo es obtener una puntuación lo más cercana posible a 21 sin pasarse.");
        System.out.println("- Cada jugador comienza con dos cartas. ");
        System.out.println("- El jugador puede pedir más cartas o plantarse");
        System.out.println("- Las cartas tienen los siguientes valores:\n" +
                "   1 Del 2 al 10: valen su número.\n" +
                "   J, Q, K: valen 10 puntos.\n" +
                "   As (A): vale 1 o 11, según convenga sin pasarse.");
        System.out.println("- Después del turno del jugador, la banca juega automáticamente:\n" +
                "   Pide cartas hasta alcanzar al menos 17 puntos.\n" +
                "   Si se pasa de 21, el jugador gana automáticamente.");
        System.out.println("- Gana quien tenga la puntuación más alta sin superar 21.");
        System.out.println(" ");
        esperar(5);

    }

    public static int repartirCarta() {

        return (int) (Math.random() * (10 - 1) + 1);

    }

    public static double apuesta(double saldo) {

        double apuesta = 0;
        boolean correcto;
        do {
            correcto = false;
            System.out.print("¿Cuánto desea apostar? (0 - Salir): ");
            if (leer.hasNextDouble()) {

                apuesta = leer.nextDouble();
                leer.nextLine();
                if (saldo < apuesta) {

                    System.out.println("No dispone de fondos suficientes para hacer la apuesta");

                } else {

                    correcto = true;

                }

            } else {

                System.out.println("Cantidad inválida, introduce un número real");
                leer.nextLine();

            }

        } while (!correcto);
       return apuesta;

    }

    public static String MostrarMano(int jugador, int mano) {

      if (jugador == 1) {

          return "Mano del jugador" + mano;

      } else if (jugador == 2) {

          return "Mano del crupier" + mano;

      }
      return " ";

    }

    public static int valorMano(int mano[], int size) {

        int total = 0;

        for (int i = 0; i <= size; i++) {

            total += mano[i];

        }
        return total;

    }

    public static boolean turnoJugador() {

        String opcion;
        boolean correcto = false;
        do {

            System.out.println("Eliga:");
            System.out.println("P - Pedir");
            System.out.println("S - Plantarse");
            opcion = leer.next();
            leer.nextLine();
            if (opcion.equalsIgnoreCase("p")) {

                correcto = true;
                return true;

            } else if (opcion.equalsIgnoreCase("S")) {

                correcto = true;
                return false;

            } else {

                System.out.println("Opción inválida");

            }

        } while (!correcto);
        return false;

    }

    public static int turnoBanca(int[] mano) {

        boolean salir = false;
        int i = 1;
        do {
            mano[i] = repartirCarta();
            i +=1;
            if (mano[i] > 17) {

                salir = true;

            }

        } while (!salir);
        return i;

    }

    public static boolean compararManos(int manoU, int manoC) {

        if (manoU == manoC) {

            return true;

        }
        return true;
    }

    public static double Juego(double saldo) {

        double apuesta;
        int[] manoC = new int[11];
        int[] manoU = new int[11];
        int i = 0;
        int Ibanca = 1;
        boolean salir;
        boolean plantado = false;
        System.out.println("Iniciando partida...");
        esperar(0.5);
        apuesta = apuesta(saldo);
        if (apuesta == 0) {

            System.out.println("Saliendo...");


        } else {

            saldo -= apuesta;
            manoU[i] = repartirCarta();
            manoC[i] = repartirCarta();

            i += 1;
            do {
                salir = false;
                System.out.println("---------------------------");
                System.out.println(MostrarMano(1,valorMano(manoC,i)));
                System.out.println(MostrarMano(2,valorMano(manoU,i)));
                System.out.println("---------------------------");
                if (valorMano(manoU,i) > 21) {

                    System.out.println("Has perdido...");
                    salir = true;

                } else {

                    if (turnoJugador()) {

                        manoU[i] = repartirCarta();
                        i += 1;

                    } else {

                        System.out.println("Repartiendo cartas al crupier...");
                        esperar(0.7);
                        Ibanca =  turnoBanca(manoC);
                        if (valorMano(manoC,i) > 21) {



                        }
                        compararManos(valorMano(manoU,i),valorMano(manoC, Ibanca));

                    }

                }

            } while (!salir);

        }

        return saldo;

    }

    public static void main(String[] args) {

        String opcion;
        boolean salir;
        double saldo = 100;
        do {

            salir = false;
            System.out.println("Bienvenido al blackjack");
            esperar(0.7);
            System.out.println("1 - Jugar partida");
            System.out.println("2 - Ver reglas");
            System.out.println("S - Salir");
            System.out.print("> ");
            opcion = leer.next();
            leer.nextLine();

            switch (opcion) {

                case "1":
                    saldo = Juego(saldo);
                    break;
                case "2":
                    reglas();
                    break;
                case "S","s":
                    salir = true;
                    System.out.println("Hasta pronto !");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;

            }

        } while (!salir);

    }

}
