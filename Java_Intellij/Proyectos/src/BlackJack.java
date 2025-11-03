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

    public static String numeroBien(double num) {

        if (num == Math.floor(num)) {

            return String.format("%.0f", num);

        } else {

            return String.format("%.2f", num);

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
        esperar(2);
        System.out.println("Presione cualquier tecla para continuar...");
        leer.nextLine();

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

          return "Mano del jugador: " + mano;

      } else if (jugador == 2) {

          return "Mano del crupier: " + mano;

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

    public static int turnoBanca(int[] mano, int[]manoU, int iU) {

        boolean salir = false;
        int i = 1;
        do {
            mano[i] = repartirCarta();
            System.out.println("---------------------------");
            System.out.println(MostrarMano(1,valorMano(manoU,iU)));
            System.out.println(MostrarMano(2,valorMano(mano,i)));
            System.out.println("---------------------------");
            esperar(0.5);
            if (valorMano(mano, i) > 17) {

                salir = true;

            }
            i += 1;

        } while (!salir);
        return i;

    }

    public static int compararManos(int manoU, int manoC) {

        if (manoU == manoC) {

            return 0;

        } else if (manoU < manoC) {

            return 1;

        } else {

            return 2;

        }

    }

    public static double Juego(double saldo) {

        double apuesta;
        int[] manoC = new int[11];
        int[] manoU = new int[11];
        int i = 0;
        int Ibanca = 1;
        int as = 0;
        boolean hayas;
        String valorAS = "";
        boolean salir;
        boolean plantado = false;
        System.out.println("Iniciando partida...");
        esperar(0.5);
        apuesta = apuesta(saldo);
        if (apuesta == 0) {

            System.out.println("Saliendo...");


        } else {

            saldo -= apuesta;
            hayas = false;
            manoU[i] = repartirCarta();
            manoC[i] = repartirCarta();

            i += 1;
            do {

                salir = false;
                System.out.println("Repartiendo cartas...");
                esperar(0.5);

                if (manoU[i-1] == 1) {

                    System.out.println("Te ha tocado un AS! Este vale como 1 o 10 en cuanto te plantes");
                    as = i-1;
                    hayas = true;
                }
                if (hayas) {

                    valorAS = " / " + (valorMano(manoU,i) + 9);

                }
                System.out.println("---------------------------");
                System.out.println(MostrarMano(1,valorMano(manoU,i)) + valorAS);
                System.out.println(MostrarMano(2,valorMano(manoC,i)));
                System.out.println("---------------------------");
                if (valorMano(manoU,i) > 21) {

                    System.out.println("Has perdido...");
                    System.out.println("Perdida: -" + numeroBien(apuesta) );
                    apuesta = 0;
                    salir = true;

                } else {

                    if (turnoJugador()) {

                        manoU[i] = repartirCarta();
                        i += 1;

                    } else {

                        esperar(0.7);
                        if (hayas) {

                            if ((valorMano(manoU, i) + 9) > 21){

                                System.out.println("Tu AS toma el valor de 1");
                                manoU[as] = 1;

                            } else if ((valorMano(manoU, i) + 9) <= 21) {

                                System.out.println("Tu AS toma el valor de 10");
                                manoU[as] = 10;

                            }

                        }


                        do {

                            System.out.println("Repartiendo cartas al crupier...");
                            esperar(0.3);
                            Ibanca = turnoBanca(manoC, manoU, i);
                            if (valorMano(manoC,i) > 21) {

                                System.out.println("¡Has ganado!");
                                apuesta *= 2;
                                System.out.println("Ganancia: +" + numeroBien(apuesta));
                                salir = true;

                            } else {

                                int resultado = compararManos(valorMano(manoU,i),valorMano(manoC, Ibanca));

                                if (resultado == 0) {

                                    System.out.println("Empate");
                                    System.out.println("Ganancia: " + 0);

                                } else if (resultado == 2) {

                                    System.out.println("¡Has ganado!");
                                    apuesta *= 2;
                                    System.out.println("Ganancia: +" + numeroBien(apuesta));

                                } else {

                                    System.out.println("Has perdido...");
                                    System.out.println("Perdida: -" + numeroBien(apuesta) );
                                    apuesta = 0;

                                }
                                salir = true;

                            }


                        } while (!salir);

                    }

                }

            } while (!salir);

        }
        saldo = saldo + apuesta;
        return saldo;

    }

    public static void main(String[] args) {

        String opcion;
        String deNuevo;
        boolean salir;
        boolean salir2;
        boolean otraVez;
        double saldo = 100;
        do {

            salir = false;
            otraVez = true;
            System.out.println("Bienvenido al blackjack");
            esperar(0.7);
            System.out.println("Dispone de un saldo de " + numeroBien(saldo));
            System.out.println("1 - Jugar partida");
            System.out.println("2 - Ver reglas");
            System.out.println("S - Salir");
            System.out.print("> ");
            opcion = leer.next();
            leer.nextLine();

            switch (opcion) {

                case "1":
                    do {
                        salir2 = false;
                        if (otraVez) {

                            saldo = Juego(saldo);
                            System.out.println("Saldo restante: " + numeroBien(saldo) + "€");
                            esperar(0.7);


                        }

                        System.out.println("¿Quieres jugar de nuevo? (S/N)");
                        deNuevo = leer.next();
                        leer.nextLine();
                        switch (deNuevo) {

                            case "S","s":
                                otraVez = true;
                                break;
                            case "N","n":
                                otraVez = false;
                                salir2 = true;
                                break;
                            default:
                                System.out.println("Opción NO válida");
                                otraVez = false;
                                break;

                        }

                    } while (!salir2);

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

        leer.close();
    }


}
