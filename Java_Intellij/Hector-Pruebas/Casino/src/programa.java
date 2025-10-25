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
        double apuesta;
        int resultado;
        String opcion;
        System.out.println("-------------------------------");
        System.out.println("Demomento solo disponemos de una ruleta con rojo, negro o verde");
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

            }

            apuesta = apuesta(saldo);
            if (apuesta == 0) {

                continue;

            }
            saldo = saldo - apuesta;
            resultado = ruletaRojoNegro();

            switch (opcion) {

                case "1":
                    if (resultado == 0) {

                        System.out.println("HA GANADO !!!");
                        saldo = apuesta * 2;
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
                        saldo = apuesta * 2;
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
                        saldo = apuesta * 35;
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
            }
            System.out.println("-------------------------------");
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
                    System.out.println("BlackJack");
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
