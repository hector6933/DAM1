import java.util.Scanner;
public class programa {

    public static Scanner leer = new Scanner(System.in);
    public static String[] log = new String[1000000000];
    public static int ILog = 0;
    public static void esperar(double seg) { // Funcion para esperar, en vez de poner este pedazo código todo el rato

        int mili = (int) (seg * 1000);

        try {

            Thread.sleep(mili);

        } catch (InterruptedException e) {

            System.out.println("Error de espera");

        }

    }

    public static int random (int max, int min) { // Funcion random, en vez de poner este pedazo código todo el rato

        return (int) (Math.random() * (max - min) + min);

    }

    public static String registroIngreso(double ingreso) {

        return "Ingresado: " + "+" + redondear(ingreso);
    }

    public static String registroRetirar(double retirado) {

        return "Retirado: " + "-" + redondear(retirado);
    }

    public static String registroRuletaGanar(double apuesta) {

        return "Ruleta: " + "+" + redondear(apuesta);
    }

    public static String registroRuletaPerder(double apuesta) {

        return "Ruleta: " + "-" + redondear(apuesta);
    }

    public static String registroBlackJackGanar(double apuesta) {

        return "BlackJack: " + "+" + redondear(apuesta);
    }

    public static String registroBlackJackPerder(double apuesta) {

        return "BlackJack: " + "-" + redondear(apuesta);
    }

    public static String registroBombasGanar(double apuesta) {

        return "Bombas: " + "+" + redondear(apuesta);
    }

    public static String registroBombasPerder(double apuesta) {

        return "Bombas: " + "-" + redondear(apuesta);
    }


    public static void registro(String registro) {

        log[ILog] = registro;
        ILog += 1;

    }

    public static void verRegistro() {

        System.out.println("Registro:");
        esperar(0.7);
        if (ILog == 0) {

            System.out.println("No hay registros");

        } else {

            for (int i = 0; i < ILog; i++) {

                System.out.println((i+1) + ". " + log[i]);

            }

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
                        registro(registroRuletaGanar(apuesta));
                        esperar(0.35);
                        System.out.println("Beneficio: +" + redondear(apuesta));
                        System.out.println("Saldo actual: " + redondear(saldo));

                    } else {

                        registro(registroRuletaPerder(apuesta));
                        System.out.println("Ha perdido...");
                        System.out.println("Saldo restante: " + redondear(saldo));

                    }

                    break;

                case "2":
                    if (resultado == 1) {

                        System.out.println("HA GANADO !!!");
                        saldo = saldo + apuesta * 2;
                        registro(registroRuletaGanar(apuesta));
                        esperar(0.35);
                        System.out.println("Beneficio: +" + redondear(apuesta));
                        System.out.println("Saldo actual: " + redondear(saldo));

                    } else {

                        registro(registroRuletaPerder(apuesta));
                        System.out.println("Ha perdido...");
                        System.out.println("Saldo restante: " + redondear(saldo));

                    }
                    break;
                case "3":
                    if (resultado == 2) {

                        System.out.println("HA GANADO !!!");
                        saldo = saldo + apuesta * 35;
                        registro(registroRuletaGanar(apuesta * 35));
                        esperar(0.35);
                        System.out.println("Beneficio: +" + redondear(((apuesta * 35) / 2)));
                        System.out.println("Saldo actual: " + redondear(saldo));

                    } else {

                        registro(registroRuletaPerder(apuesta));
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
        boolean plantado = false;
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

            if (manoU == manoC && plantado) {

                System.out.println("Empate");
                salir = true;
                return apuesta;

            } else if (manoU > 21 || (plantado && manoC <= 21 && manoC > manoU)) {

                registro(registroBlackJackPerder(apuesta));
                System.out.println("Ha perido...");
                esperar(0.5);
                salir = true;
                return 0;

            } else if ( manoC >= 17 && plantado) {

                registro(registroBlackJackGanar(apuesta));
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
                            plantado = true;
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

    public static double gestionSaldo(double saldo) {

        boolean salir;
        boolean correcto;
        String opcion;
        double retirar;
        double ingresar;
        esperar(0.5);
        do {
            salir = false;
            correcto = false;
            System.out.println("-------------------------------");
            System.out.println("Eliga entre las siguientes opciones:");
            System.out.println("1 - Ingresar");
            System.out.println("2 - Retirar");
            System.out.println("3 - Ver registro");
            System.out.println("S - Salir");
            opcion = leer.next();
            leer.nextLine();
            switch (opcion) {

                case "1":
                    do {
                        System.out.println("¿Cuánto desea ingresar?");
                        if (leer.hasNextDouble()) {

                            ingresar = leer.nextDouble();
                            leer.nextLine();
                            correcto = true;
                            saldo = saldo + ingresar;
                            registro(registroIngreso(ingresar));
                            esperar(0.2);
                            System.out.println("Ingrsado correctamente " + "+" + redondear(ingresar) + " al saldo.");
                            esperar(0.5);
                            System.out.println("-------------------------------");
                            System.out.println("Saldo actual: " + redondear(saldo));

                        } else {

                            esperar(0.3);
                            System.out.println("Cantidad inválida, por favor, ingrese un número real.");
                            leer.nextLine();

                        }

                    } while (!correcto);

                    break;
                case "2":
                    do {
                        System.out.println("¿Cuánto desea retirar?");
                        if (leer.hasNextDouble()) {

                            retirar = leer.nextDouble();
                            leer.nextLine();
                            esperar(0.2);
                            if (retirar > saldo) {

                                System.out.println("NO puede retirar más saldo del que dispone");

                            } else {

                                saldo = saldo - retirar;
                                registro(registroRetirar(retirar));
                                System.out.println("Retirado correctamente " + "-" + redondear(retirar) + " del saldo.");
                                esperar(0.5);
                                System.out.println("-------------------------------");
                                System.out.println("Saldo actual: " + redondear(saldo));

                            }
                            correcto = true;

                        } else {

                            esperar(0.3);
                            System.out.println("Cantidad inválida, por favor, ingrese un número real.");
                            leer.nextLine();

                        }

                    } while (!correcto);

                    break;
                case "3":
                    esperar(0.2);
                    verRegistro();
                    break;
                case "S","s":
                    salir = true;
                    break;
                default:
                    esperar(0.3);
                    System.out.println("Opción no válida");
                    break;
            }

        } while (!salir);

        return saldo;
    }

    public static double campoBombas(int bombas, String[][] campo, double apuesta) {

        boolean salir;
        boolean correcto;
        int random1;
        int random2;

        int pos1 = 0;
        int pos2 = 0;

        int max = 0;
        int min = 5;;
        int contador = 0;

        // Printear campo
        for (int i = 0; i < 6; i++) {

            System.out.print("   " + (i+1));

        }

        System.out.println(" ");

        for (int i = 0; i < 6; i++) {

            System.out.print((i+1) + " ");
            for (int j = 0; j < 6; j++) {

                campo[i][j] = "x";
                System.out.print("["+ campo[i][j] + "] ");

            }
            System.out.println(" ");

        }
        // Finalizar printear campo

        while (contador != bombas){

            random1 = random(max,min);
            random2 = random(max,min);
            campo[random1][random2] = "☼";

            contador +=1;
        }

        if (bombas != 0) {

            do {
                salir = false;
                System.out.println("¿Que posicion quiere revelar?");
                do {
                    correcto = false;
                    System.out.print("Pos 1:");
                    if (leer.hasNextInt()) {

                        pos1 = leer.nextInt();
                        leer.nextLine();
                        if (pos1 < 1 || pos1 > 6) {

                            System.out.println("El número debe de estar comprendido entre 1 y 6");

                        } else {

                            do {
                                System.out.print("Pos 2:");
                                if (leer.hasNextInt()) {

                                    pos2 = leer.nextInt();
                                    leer.nextLine();
                                    if (pos2 < 1 || pos2 > 6) {

                                        System.out.println("El número debe de estar comprendido entre 1 y 6");

                                    } else {

                                        correcto = true;

                                    }

                                } else {

                                    System.out.println("Número inválido, debe de ser un número entero.");
                                    leer.nextLine();

                                }

                            } while (!correcto);

                        }

                    } else {

                        System.out.println("Número inválido, debe de ser un número entero.");
                        leer.nextLine();

                    }

                } while (!correcto);

                if (campo[pos1][pos2].equalsIgnoreCase("☼")) {

                    for (int i = 0; i < 5; i++) {

                        System.out.print("   " + (i+1));

                    }

                    System.out.println(" ");

                    for (int i = 0; i < 6; i++) {

                        System.out.print((i+1) + " ");
                        for (int j = 0; j < 6; j++) {

                            campo[i][j] = "x";
                            System.out.print("["+ campo[i][j] + "] ");

                        }
                        System.out.println(" ");

                    }
                    System.out.println("¡ BOMBA !");
                    esperar(0.7);
                    System.out.println("Has perdido");
                    registro(registroBombasPerder(apuesta));
                    apuesta = 0;

                }

            } while (!salir);

            // Por hacer:
            // Hacer el multiplicador de dinero para las bombas, si llena la mitad del campo y consigue desbloquear todos sin bomba es un x4
            // Si desbloquea un cuarto de las bombas

        }
        return apuesta;


    }

    public static double bombas(double saldo) {

        boolean salir;
        boolean correcto;
        double apuesta = 0;
        String[][] campo = new String[6][6];
        int bombas;
        System.out.println("☼ Bienvenido a las bombas ☼");
        esperar(0.7);
        System.out.println("Bombardeen perú");

        do {
            salir = false;
            correcto = false;
            System.out.println("Este es el campo: ");
            campoBombas(0, campo, apuesta);
            esperar(0.5);
            apuesta = apuesta(saldo);
            if (apuesta == 0) {

                salir = true;
                break;

            } else {

                do {
                    System.out.print("¿Cuántas bombas quieres? (0 - Salir): ");
                    if (leer.hasNextInt()) {

                        bombas = leer.nextInt();
                        leer.nextLine();
                        correcto = true;
                        if (bombas == 0) {

                            salir = true;
                            break;

                        } else {

                            saldo = saldo + campoBombas(bombas, campo, apuesta);

                        }

                    } else {

                        System.out.println("Número inválido, debe de ser un número entero comprendido en x x");
                        leer.nextLine();

                    }

                } while (!correcto);

            }

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
                    saldo = bombas(saldo);
                    break;

                case "4":
                    saldo = gestionSaldo(saldo);
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
