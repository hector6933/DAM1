import java.util.Scanner;
public class programa {

    static Scanner leer = new Scanner(System.in);
    public static void esperar(double seg) { // Funcion para esperar, en vez de poner este pedazo código todo el rato

        int mili = (int) (seg * 1000);

        try {

            Thread.sleep(mili);

        } catch (InterruptedException e) {

            System.out.println("Erro de espera");

        }

    }

    public static int random (int max, int min) {

        return (int) (Math.random() * (max - min) + min);

    }

    public static String redondear (double saldo) {

        if (saldo == Math.floor(saldo)) {

            return String.format("%.0f", saldo) + "€";

        } else {

            return String.format("%.2f",saldo) + "€";

        }

    }

    public static int ruletaRojoNegro() {

        boolean salir = false;
        int min = 0;
        int max = 99;
        int random;
        int contador = 0;
        double i = 0.1;
        System.out.println("Girando la ruleta...");
        do {

            random = (int) (Math.random() * (max - min) + min);

            if (random >= 1 && random <= 49) {

                System.out.println("Rojo");

            } else if (random >= 50 && random <= 99) {

                System.out.println("Negro");

            } else if (random == 0) {

                System.out.println("VERDE");

            }
            i = (i + 0.15);
            esperar(i);
            contador +=1;

        } while (contador != 10);


        if (random >= 1 && random <= 49) {

            return 0;

        } else if (random >= 50 && random <= 100) {

            return 1;

        } else if (random == 0) {

            return 2;

        }

        return 69;

    }

    public static double apuesta(double saldo) {

        boolean salir;
        boolean salir2;
        double apuesta;
        String opcion;
        do {

            salir = false;
            salir2 = false;
            System.out.println("¿Cuánto desea apostar? (0 - Salir)");
            if (leer.hasNextDouble()) {

                apuesta = leer.nextDouble();
                leer.nextLine();
                if (apuesta == 0) {

                    salir = true;

                } else {

                    do {

                        System.out.println("¿Está seguro? (S/N)");
                        opcion = leer.next();
                        leer.nextLine();
                        switch (opcion) {

                            case "S","s":
                                if (apuesta > saldo) {

                                    System.out.println("No dispone de fondos suficientes para hacer la apuesta");
                                    salir2 = true;

                                } else {

                                    salir2 = true;
                                    salir = true;
                                    return apuesta;

                                }

                            case "N","n":
                                salir2 = true;
                                break;
                            default:
                                System.out.println("Opción NO válida");
                                break;

                        }

                    } while (!salir2);

                }

            } else {

                System.out.println("¡ Introduzca una cantidad válida !");
                leer.nextLine();

            }

        } while (!salir);
        return 0;

    }

    public static double ruleta(double saldo) {

        boolean salir;
        double apuesta = 0;
        int resultado = 99;
        String opcion;
        System.out.println("• Bienvenido a la ruleta •");
        esperar(0.4);
        System.out.print("Donde el destino, ");
        esperar(1.2);
        System.out.println("elige su fortuna.");
        esperar(0.7);
        System.out.println("-------------------------------");
        System.out.println("De momento solo disponemos de una ruleta con rojo, negro o verde.");
        esperar(0.7);
        do {

            salir = false;
            System.out.println("Apuesta:");
            System.out.println("1 - Rojo");
            System.out.println("2 - Negro");
            System.out.println("3 - Verde");
            System.out.println("S - Salir");
            opcion = leer.next();
            leer.nextLine();
            if (opcion.equalsIgnoreCase("S")) {

                salir = true;
                break;

            } else if (opcion.equalsIgnoreCase("1") || opcion.equalsIgnoreCase("2") || opcion.equalsIgnoreCase("3")) {

                apuesta = apuesta(saldo);
                if (apuesta == 0) {

                    continue;

                }
                saldo = saldo - apuesta;
                resultado = ruletaRojoNegro();

            }

            switch (opcion) {

                case "1":
                    if (resultado == 0) {

                        System.out.println("HA GANADO !!!");
                        saldo = saldo + apuesta * 2;
                        esperar(0.35);
                        System.out.println("Beneficio: +" + redondear(apuesta));
                        System.out.println("Saldo actual: " + redondear(saldo));

                    } else {

                        System.out.println("Ha perdido...");
                        System.out.println("Saldo restante: " + redondear(saldo));

                    }

                    break;

                case "2":
                    if (resultado == 1) {

                        System.out.println("HA GANADO !!!");
                        saldo = saldo + apuesta * 2;
                        esperar(0.35);
                        System.out.println("Beneficio: +" + redondear(apuesta));
                        System.out.println("Saldo actual: " + redondear(saldo));

                    } else {

                        System.out.println("Ha perdido...");
                        System.out.println("Saldo restante: " + redondear(saldo));

                    }
                    break;
                case "3":
                    if (resultado == 2) {

                        System.out.println("HA GANADO !!!");
                        saldo = saldo + apuesta * 35;
                        esperar(0.35);
                        System.out.println("Beneficio: +" + redondear(((apuesta * 35) / 2)));
                        System.out.println("Saldo actual: " + redondear(saldo));

                    } else {

                        System.out.println("Ha perdido...");
                        System.out.println("Saldo restante: " + redondear(saldo));

                    }
                    break;
                case "S","s":
                    System.out.println("Saliendo...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida");
                    esperar(0.5);
                    break;
            }
            System.out.println("-------------------------------");
        } while (!salir);
        return saldo;

    }

    public static double blackJackCartas(double apuesta) {

        int random;
        String opcion;
        int min = 1;
        int max = 11;
        int manoC = random(max,min);
        int manoU = random(max,min);
        boolean salir;
        boolean correcto;
        do {
            salir = false;
            if (manoC < 17) {

                System.out.println("Repartiendo cartas...");
                esperar(1);
                System.out.println("-------------------------------");
                System.out.println("Tu mano: " + manoU);
                System.out.println("Mano crupier: " + manoC);
                System.out.println("-------------------------------");
                esperar(0.5);

            }

            if (manoU == 21 && manoC == 21) {

                System.out.println("Empate");
                salir = true;
                return apuesta;

            } else if (manoU > 21) {

                System.out.println("Ha perido...");
                esperar(0.5);
                salir = true;
                return 0;

            } else if ( manoC >= 17 && manoU <= 21) {


                System.out.println("¡ HA GANADO !");
                salir = true;
                return apuesta * 2;

            } else {

                do {
                    correcto = false;
                    System.out.println("0 - Plantarse");
                    System.out.println("1 - Pedir");
                    opcion = leer.next();
                    leer.nextLine();
                    switch (opcion) {

                        case "0":

                            while (manoC < 17) {

                                manoC = manoC + random(max,min);
                                System.out.println("-------------------------------");
                                System.out.println("Tu mano: " + manoU);
                                System.out.println("Mano crupier: " + manoC);
                                System.out.println("-------------------------------");
                                esperar(0.6);

                            }
                            correcto = true;

                            break;
                        case "1":
                            manoU = manoU + random(max,min);
                            correcto = true;
                            break;
                        default:
                            System.out.println("Opción inválida");
                            break;
                    }

                } while (!correcto);

            }

        } while (!salir);

        return 0;
    }

    public static double blackJack(double saldo) {

        boolean salir;
        boolean correcto;
        double apuesta;
        String opcion;
        System.out.println("♣ Bienvenido al Black Jack ♣");
        esperar(0.7);
        System.out.println("Aquí estan usted, el destino y la fortuna.");
        esperar(1);
        do {

            salir = false;
            apuesta = apuesta(saldo);
            if (apuesta == 0) {

                salir = true;
                break;

            }
            saldo = saldo - apuesta;
            saldo = saldo + blackJackCartas(apuesta);
            System.out.println("Saldo restante: " + redondear(saldo));
            do {
                correcto = false;
                System.out.println("¿Quiere jugar de nuevo? (S/N)");
                opcion = leer.next();
                leer.nextLine();
                switch (opcion) {

                    case "S","s":
                        correcto = true;
                        break;
                    case "N","n":
                        correcto = true;
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

            } while (!correcto);

        } while (!salir);

        return saldo;
    }


    public static void main(String[] args) {


        boolean salir = false;
        double saldo = 1000;
        String opcion;

        System.out.println("♦ Hola y bienvenido al HecSino ♦");
        do {

            esperar(0.7);

            System.out.println("Dispone de un saldo de " + redondear(saldo));

            esperar(1);

            System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼");
            System.out.println("¿Qué desea hacer hoy?");
            System.out.println("1 - Ruleta");
            System.out.println("2 - BlackJack");
            System.out.println("3 - Bombas");
            System.out.println("4 - Gestión saldo");
            System.out.println("S - Salir");
            opcion = leer.next();
            leer.nextLine();

            switch (opcion) {

                case "1":
                    saldo = ruleta(saldo);
                    break;

                case "2":
                    saldo = blackJack(saldo);
                    break;

                case "3":
                    System.out.println("Bombas");
                    break;

                case "4":
                    System.out.println("Gestión saldo");
                    break;

                case "S","s":
                    System.out.println("¡ Hasta pronto !");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción NO válida");
                    break;
            }

            System.out.println("▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼▲▼");


        } while (!salir);

    }

}
